/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  ResourceGridService.java 2014-10-03 17:00:43 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IResourceGridDAO;
import cn.starteasy.core.common.adminui.backend.domain.ResourceGrid;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IResourceGridService extends IBaseService<Long, IResourceGridDAO,ResourceGrid>,IPageService<IResourceGridDAO,ResourceGrid> {
}
