package cn.starteasy.core.common.dao;

import cn.starteasy.core.common.domain.BaseDomain;

import java.io.Serializable;

/**
 * DAO 基类   ,  如果IBaseDAO不满足特殊的场景,可以从这里继承(这样会保证任何基于IDAO接口的增强机制你都可以享有)
 * <p>
 * 创建时间: 16/9/22 下午8:59<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public interface IDAO<T extends BaseDomain<ID>, ID extends Serializable> {
}
