package cn.starteasy.core.common.service.admin;

/**
 * 数据权限接口   （业务相关接口）
 * <p/>
 * 创建时间: 14-8-16 下午10:20<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public interface IDataPermService {
    /**
     * 拼装当前用户特定业务模型主体的数据权限sql
     * @param resUrl 资源url
     * @return
     */
    public String makeDataPermSql(String resUrl);
}
