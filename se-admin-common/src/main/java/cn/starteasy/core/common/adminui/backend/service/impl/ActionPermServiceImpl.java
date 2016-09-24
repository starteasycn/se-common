package cn.starteasy.core.common.adminui.backend.service.impl;

import cn.starteasy.core.common.adminui.backend.dao.IPermissionDAO;
import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.domain.ResourceAction;
import cn.starteasy.core.common.adminui.backend.service.IActionPermService;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 14-10-2 下午5:26<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
@Service("actionPermServiceImpl")
public class ActionPermServiceImpl implements IActionPermService {
    @Autowired
    private IPermissionDAO permissionDAO;

    @Override
    public List<Resource> getResourcePerms(Object userId) {
        return getResourcePerms(userId, null);
    }

    @Override
    public List<Resource> getResourcePerms(Object userId, String product) {
        return permissionDAO.getResByPerm(userId,product,null);
    }

    @Override
    public List<Resource> getResourcePerms(Object userId, String product, String hide) {
        return permissionDAO.getResByPerm(userId,product,hide);
    }

    @Override
    public Set<String> getActionPermsByRes(Object userId, Object resourceId) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("userId", userId);
        params.put("resourceId", resourceId);
        List<ResourceAction> resourceActionList = permissionDAO.getResActionByPerm(params);
        Set<String> actionSet = Sets.newHashSet();
        for(ResourceAction resourceAction : resourceActionList){
            actionSet.add(resourceAction.getActionAlias());
        }
        return actionSet;
    }

    @Override
    public Map<String, Set<String>> getActionPerms(Object userId) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("userId", userId);
        List<ResourceAction> resourceActionList = permissionDAO.getResActionByPerm(params);

        Map<String, Set<String>> actionPerms = Maps.newHashMap();
        Set<String> perms = null;
        for(ResourceAction resourceAction : resourceActionList){
            perms = actionPerms.get(resourceAction.getResourceId());
            if(perms == null){
                perms = Sets.newHashSet();
            }
            perms.add(resourceAction.getActionAlias());

            actionPerms.put(String.valueOf(resourceAction.getResourceId()), perms);
        }

        return actionPerms;
    }
}
