/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  RoleUserService.java 2014-10-03 17:00:43 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IRoleUserDAO;
import cn.starteasy.core.common.adminui.backend.domain.RoleUser;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IRoleUserService extends IBaseService<Long, IRoleUserDAO,RoleUser>,IPageService<IRoleUserDAO,RoleUser> {
}
