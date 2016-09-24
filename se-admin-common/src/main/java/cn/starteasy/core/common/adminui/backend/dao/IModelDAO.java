/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  ModelDAO.java 2014-10-03 16:39:52 $
 */
package cn.starteasy.core.common.adminui.backend.dao;

import cn.starteasy.core.common.adminui.backend.domain.Model;
import cn.starteasy.core.common.dao.IBaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelDAO extends IBaseDAO<Long, Model> {
	

}
