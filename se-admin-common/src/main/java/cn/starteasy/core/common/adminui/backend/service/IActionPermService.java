package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.domain.Resource;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能权限接口
 * <p/>
 * 创建时间: 14-10-2 下午12:52<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public interface IActionPermService {
    /**
     * 获取用户的菜单权限
     * @param userId
     * @return
     */
    public List<Resource> getResourcePerms(Object userId);

    List<Resource> getResourcePerms(Object userId, String product);

    List<Resource> getResourcePerms(Object userId, String product, String hide);

    /**
     * 获取用户特定页面的功能权限
     * @param userId         用户id
     * @param resourceId     页面资源id
     * @return 页面内的功能权限集合
     */
    public Set<String> getActionPermsByRes(Object userId, Object resourceId);

    /**
     * 获取用户的所有功能权限
     * @param userId         用户id
     * @return <页面id, 页面内的功能权限集合>
     */
    public Map<String, Set<String>> getActionPerms(Object userId);
}
