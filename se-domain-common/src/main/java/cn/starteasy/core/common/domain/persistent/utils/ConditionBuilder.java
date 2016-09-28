package cn.starteasy.core.common.domain.persistent.utils;

import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.view.admin.SearchField;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * TODO 一句话描述该类用途
 * <p>
 * 创建时间: 16/9/28 下午5:35<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class ConditionBuilder {
    public static Map<String, Object> condition(String field, SearchEnum op, Object data){
        Map<String, Object> conditions = Maps.newHashMap();
        SearchField searchField = new SearchField(field, op.getValue(), data);
        conditions.put(field, searchField);

        return conditions;
    }
}
