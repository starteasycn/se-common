package cn.starteasy.core.common.adminui.controller.helpers;


import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.service.IActionPermService;
import cn.starteasy.core.common.adminui.backend.service.IResourceService;
import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.persistent.utils.ConditionBuilder;
import cn.starteasy.core.common.utils.UserContext;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能权限助手类
 * <p/>
 * 创建时间: 14-10-2 下午6:00<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
@Service("actionPermHelper")
public class ActionPermHelper {
    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IActionPermService actionPermService;

    public final Set<String> getActionPerm(String mainObj) {
        Map<String,Object> map = new HashMap<>();
        map.put("bizModelName", mainObj);
        Resource resource = resourceService.viewOne(null, map, Lists.newArrayList());
        if(resource==null)
            return null;
        return actionPermService.getActionPermsByRes(UserContext.getCurrentUser().getId(),resource.getId());
    }

    public final Set<String> getActionPerm(String mainObj, String product) {
        Map<String,Object> map = new ConditionBuilder().and("bizModelName", SearchEnum.eq, mainObj).and("product", SearchEnum.eq, product).build();

        Resource resource = resourceService.viewOne(null, map, null);
        if(resource==null)
            return null;
        return actionPermService.getActionPermsByRes(UserContext.getCurrentUser().getId(),resource.getId());
    }

    public final List<Resource> getResourcePerm() {
        return actionPermService.getResourcePerms(UserContext.getCurrentUser().getId(),null,"0");
    }


    public final List<Resource> getResourcePerm(String product) {
        //return getResourcePerm(UserContext.getCurrentUser().getId(), product,"0");
        return getResourcePerm(UserContext.getCurrentUser().getId(), product,"0");
    }

    public final List<Resource> getResourcePerm(Object uid, String product) {
        return actionPermService.getResourcePerms( uid, product);
    }

    public final List<Resource> getResourcePerm(Object uid, String product, String hide) {
        return actionPermService.getResourcePerms( uid, product,hide);
    }

}
