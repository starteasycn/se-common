
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  BaseServiceMaps.java 2014-09-26 11:10:51 $
 */

package cn.starteasy.core.common.adminui.controller.helpers;

import cn.starteasy.core.common.adminui.backend.service.*;
import cn.starteasy.core.common.service.IBaseService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * Created by qyang on 14-9-24.
 */
public class BaseServiceMaps {

    @Autowired
    private IModelService modelService;
    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IResourceActionService resourceActionService;

    @Autowired
    private IResourceGridService resourceGridService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleResourceService roleResourceService;

    @Autowired
    private IRoleUserService roleUserService;

    @Autowired
    private IUserDataService userDataService;

    @Autowired
    private IDatagroupDataService datagroupDataService;

    @Autowired
    private IDatagroupService datagroupService;

    @Autowired
    private IDataModelService dataModelService;

    @Autowired
    private IUserDatagroupService userDatagroupService;

    protected final Map<String, IBaseService> serviceMap = Maps.newHashMap();

    protected void init(){
        //key 全部为小写
        serviceMap.put("datamodel",dataModelService);
        serviceMap.put("model",modelService);
        serviceMap.put("resource",resourceService);
        serviceMap.put("resourceaction",resourceActionService);
        serviceMap.put("resourcegrid",resourceGridService);
        serviceMap.put("role",roleService);
        serviceMap.put("roleresource",roleResourceService);
        serviceMap.put("roleuser",roleUserService);
        serviceMap.put("userdata",userDataService);
        serviceMap.put("datagroupData".toLowerCase(),datagroupDataService);
        serviceMap.put("datagroup".toLowerCase(),datagroupService);
        serviceMap.put("userDatagroup".toLowerCase(),userDatagroupService);
    }

    public IBaseService get(String mainObj){
        return serviceMap.get(mainObj);
    }

}
