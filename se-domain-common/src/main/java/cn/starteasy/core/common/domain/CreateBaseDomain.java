/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: tecc-cn.thinkjoy.common
 * $Id: CreateBaseDomain.java 2014年4月14日 下午10:40:25 $
 */
package cn.starteasy.core.common.domain;

import java.util.Date;

/**
 * 具有操作员操作属性的domain
 * <p/>
 * 创建时间: 2014年4月14日 下午10:40:25 <br/>
 *
 * @author qyang
 * @version
 * @since v0.0.1
 */
public class CreateBaseDomain<T> extends BaseDomain<T> {
    /** 创建人及创建时间 */
    private Object creator;
    private Long createDate;

    /** 最后修改人及最后修改时间 */
    private Object lastModifier;
    private Long lastModDate = System.currentTimeMillis();
    private Integer status;

    private String creatorName;
    private String lastModifierName;

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Object getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(Object lastModifier) {
        this.lastModifier = lastModifier;
    }

    public Long getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Long lastModDate) {
        this.lastModDate = lastModDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDateAsDate() {
        if(createDate == null){
            return new Date();
        }
        return createDate > 0 ? new Date(createDate) : null;
    }

    public Date getLastModDateAsDate() {
        if(lastModDate == null){
            return new Date();
        }
        return lastModDate > 0 ? new Date(lastModDate) : null;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }
}
