package cn.starteasy.core.web.restful;

import cn.starteasy.core.common.protocol.RequestT;
import com.alibaba.fastjson.TypeReference;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 14/11/30 上午11:16<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class RawTypeReference {
    public static TypeReference stringTypeReference = new TypeReference<RequestT<String>>(){};
    public static TypeReference booleanTypeReference = new TypeReference<RequestT<Boolean>>(){};
    public static TypeReference integerTypeReference = new TypeReference<RequestT<Integer>>(){};
    public static TypeReference longTypeReference = new TypeReference<RequestT<Long>>(){};
}
