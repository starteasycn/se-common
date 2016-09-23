package cn.starteasy.core.common.service.impl;


import cn.starteasy.core.common.dao.IBaseDAO;
import cn.starteasy.core.common.domain.BaseDomain;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPersistenceProvider;

import java.util.List;
import java.util.Map;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 16/1/10 上午11:43<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public abstract class AbstractPersistenceProvider implements IPersistenceProvider {

    public abstract IBaseService getService();

    @Override
    public void verifyData(Map<String, Object> dataMap) {

    }

    @Override
    public IBaseDAO getDao() {
        return null;
    }


}
