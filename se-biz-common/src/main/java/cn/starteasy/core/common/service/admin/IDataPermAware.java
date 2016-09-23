package cn.starteasy.core.common.service.admin;

/**
 * 是否需要数据权限注入
 * <p/>
 * 创建时间: 14-9-23 下午2:10<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public interface IDataPermAware {
    /**
     * 是否进行数据权限
     * @return true 需要数据权限控制
     */
    public boolean getEnableDataPerm();
}
