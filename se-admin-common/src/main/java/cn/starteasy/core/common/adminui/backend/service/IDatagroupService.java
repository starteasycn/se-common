/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: cmc
 * $Id:  DatagroupService.java 2014-10-27 10:37:54 $
 */

package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IDatagroupDAO;
import cn.starteasy.core.common.adminui.backend.domain.Datagroup;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IDatagroupService extends IBaseService<Long, IDatagroupDAO, Datagroup>,IPageService<IDatagroupDAO, Datagroup> {

}
