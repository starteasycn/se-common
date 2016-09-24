/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  DataModelService.java 2014-10-03 17:00:40 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IDataModelDAO;
import cn.starteasy.core.common.adminui.backend.domain.DataModel;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IDataModelService extends IBaseService<Integer, IDataModelDAO,DataModel>,IPageService<IDataModelDAO,DataModel> {
}
