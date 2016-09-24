/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  UserDataService.java 2014-10-03 17:00:44 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IUserDataDAO;
import cn.starteasy.core.common.adminui.backend.domain.UserData;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IUserDataService extends IBaseService<Long, IUserDataDAO,UserData>,IPageService<IUserDataDAO,UserData> {
}
