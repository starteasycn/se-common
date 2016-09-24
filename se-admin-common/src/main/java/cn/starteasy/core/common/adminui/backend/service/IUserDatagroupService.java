/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: cmc
 * $Id:  UserDatagroupService.java 2014-10-27 10:37:55 $
 */

package cn.starteasy.core.common.adminui.backend.service;


import cn.starteasy.core.common.adminui.backend.dao.IUserDatagroupDAO;
import cn.starteasy.core.common.adminui.backend.domain.UserDatagroup;
import cn.starteasy.core.common.dao.IBaseDAO;
import cn.starteasy.core.common.domain.BaseDomain;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

import java.io.Serializable;

public interface IUserDatagroupService extends IBaseService<Long, IUserDatagroupDAO, UserDatagroup>,IPageService<IUserDatagroupDAO, UserDatagroup> {

}
