/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  ResourceService.java 2014-10-03 17:00:42 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IResourceDAO;
import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IResourceService extends IBaseService<Long, IResourceDAO,Resource>,IPageService<IResourceDAO,Resource> {
}
