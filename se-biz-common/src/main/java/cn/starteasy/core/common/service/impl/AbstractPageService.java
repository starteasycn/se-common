package cn.starteasy.core.common.service.impl;


import cn.starteasy.core.common.dao.IBaseDAO;
import cn.starteasy.core.common.domain.BaseDomain;
import cn.starteasy.core.common.domain.persistent.Sorter;
import cn.starteasy.core.common.domain.view.BizData4Page;
import cn.starteasy.core.common.service.IPageService;
import cn.starteasy.core.common.utils.BizData4PageBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页处理的抽象实现，继承自baseService，具备业务模型的基本业务逻辑处理
 * <p/>
 * 创建时间: 14-9-3 下午10:21<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public abstract class AbstractPageService<ID extends Serializable, D extends IBaseDAO,T extends BaseDomain> extends AbstractBaseService<ID, D,T> implements IPageService<D,T> {

    @Override
    public BizData4Page queryPage(Map<String, Object> selector, Map<String, Object> condition, int curPage, int offset, int rows, List<Sorter> sorter) {

        return BizData4PageBuilder.createBizData4Page(getDao(), selector, condition, null, curPage, offset, rows, sorter);
    }

    @Override
    public BizData4Page queryPageByWhereSql(Map<String, Object> selector, String nativeSql, int curPage, int offset, int rows, List<Sorter> sorter) {
        return BizData4PageBuilder.createBizData4Page(getDao(), selector, null, nativeSql, curPage, offset, rows, sorter);
    }
}


