/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: cmc
 * $Id:  DatagroupDataService.java 2014-10-27 10:37:55 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IDatagroupDataDAO;
import cn.starteasy.core.common.adminui.backend.domain.DatagroupData;
import cn.starteasy.core.common.dao.IBaseDAO;
import cn.starteasy.core.common.domain.BaseDomain;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IDatagroupDataService extends IBaseService<Long, IDatagroupDataDAO, DatagroupData>,IPageService<IDatagroupDataDAO, DatagroupData> {

}
