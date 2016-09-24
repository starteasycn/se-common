package cn.starteasy.core.web.restful;

import cn.starteasy.core.common.protocol.RequestT;
import cn.starteasy.core.common.protocol.ResponseT;
import cn.starteasy.core.common.protocol.utils.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpRequest;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * 扩展的fastjson convert  针对创易特有协议扩展
 * <p/>
 * 创建时间: 14/11/23 下午6:38<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class ExtFastJsonHttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    public Logger logger = LoggerFactory.getLogger(ExtFastJsonHttpMessageConverter.class);

    public final static Charset UTF8     = Charset.forName("UTF-8");

    private Charset charset  = UTF8;

    private SerializerFeature[] features = new SerializerFeature[0];

    public ExtFastJsonHttpMessageConverter(){
        super(new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8));
        features = new SerializerFeature[1];
        features[0] = SerializerFeature.DisableCircularReferenceDetect;
    }

    private ITypeReference iTypeReference;

    private String dataStyleType;

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public SerializerFeature[] getFeatures() {
        return features;
    }

    public void setFeatures(SerializerFeature... features) {
        this.features = features;
    }

    public ITypeReference getiTypeReference() {
        return iTypeReference;
    }

    public void setiTypeReference(ITypeReference iTypeReference) {
        this.iTypeReference = iTypeReference;
    }

    public String getDataStyleType() {
        return dataStyleType;
    }

    public void setDataStyleType(String dataStyleType) {
        this.dataStyleType = dataStyleType;
    }

    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream in = inputMessage.getBody();

        byte[] buf = new byte[1024];
        for (;;) {
            int len = in.read(buf);
            if (len == -1) {
                break;
            }

            if (len > 0) {
                baos.write(buf, 0, len);
            }
        }

        byte[] bytes = baos.toByteArray();
        //String url = ((ServletServerHttpRequest) inputMessage).getURI().getPath();
        String url = ((ServletServerHttpRequest)((ServletServerHttpRequest) inputMessage)).getServletRequest().getServletPath();
        //支持 url包含？参数
        int size = url.indexOf("?");
        if(size != -1){
            url = url.substring(0, size);
        }

        T t = JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(), iTypeReference.getTypeReference(url).getType());

        //请求数据是RequestT对象时styledData处理
        t = resetRequestData(url, t);

        return t;
    }

    @Override
    protected void writeInternal(T t, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        ResponseT<T> response = new ResponseT<T>(RtnCodeEnum.SUCCESS);

        response.setBizData(t);

        //响应数据是ResponseT对象时style处理
        resetResponseData(response);

        OutputStream out = outputMessage.getBody();
        String text = JSON.toJSONString(response, getSerializeFilter(response), features);
        byte[] bytes = text.getBytes(charset);
        out.write(bytes);
    }

    //获取序列化过滤器
    private SerializeFilter[] getSerializeFilter(ResponseT<T> response){
        if(response.getStyle() != null && !StyleEnum.PLAIN.equals(response.getStyle())){
            return SerializeFilterBuilder.instance;
        }
        return new SerializeFilter[0];
    }


    private static class SerializeFilterBuilder{
        private static SerializeFilter[] instance = new SerializeFilter[]{new ExtPropertyFilter()};
    }

    /**
     * 请求中的数据解密并设置到业务对象<br/>
     */
    private T resetRequestData(String url, T t){
        if(t instanceof RequestT){
            RequestT requestT = (RequestT)t;
            if(requestT.getStyle() != null && !StyleEnum.PLAIN.equals(requestT.getStyle())){
                Type[] types = ((ParameterizedTypeImpl)iTypeReference.getTypeReference(url).getType()).getActualTypeArguments();
                Type type = (types!=null & types.length > 0) ? types[0] : null;
                if(type != null){
                    Object data = requestT.getData();
                    if(requestT.getData() instanceof JSONObject){
                        data = JSON.parseObject(((JSONObject) requestT.getData()).toJSONString(), type);
                    }
                    StyleEnum style = requestT.getStyle();
                    requestT.setStyle(StyleEnum.PLAIN);
                    requestT.setData(data);
                    requestT.setStyledData(null);
                    requestT.setStyle(style);
                    return (T)requestT;
                }
            }
        }
        return t;
    }

    /**
     * 响应数据是ResponseT对象时处理<br/>
     * bizData --> styledData
     * @param response
     */
    private void resetResponseData(ResponseT<T> response){
        if(response.getBizData() != null){
            StyleEnum style = StyleEnum.codeOf(dataStyleType);
            if(!StyleEnum.PLAIN.equals(style)){
                response.setStyle(style);
                //wrapper data with style
                String jsonData = JSON.toJSONString(response.getBizData());
                String styledData = null;
                if(StyleEnum.GZIP.equals(style)){
                    styledData = ByteUtils.Bytes2HexString(StringGZIPUtils.compressToByte(jsonData));
                }else if(StyleEnum.AES.equals(style)){
                    try {
                        styledData = AES128Utils.encrypt2str(jsonData);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(!Strings.isNullOrEmpty(styledData)){
                    response.setStyledData(styledData);
                    response.setBizData(null);
                }
            }
        }
    }
}
