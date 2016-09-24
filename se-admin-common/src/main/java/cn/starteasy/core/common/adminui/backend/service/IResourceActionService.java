/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  ResourceActionService.java 2014-10-03 17:00:42 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IResourceActionDAO;
import cn.starteasy.core.common.adminui.backend.domain.ResourceAction;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IResourceActionService extends IBaseService<Long, IResourceActionDAO,ResourceAction>,IPageService<IResourceActionDAO,ResourceAction> {
}
