/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: cmc
 * $Id:  UserDatagroup.java 2014-10-27 10:37:55 $
 */



package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.CreateBaseDomain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserDatagroup extends CreateBaseDomain<Long>{
    private Integer datagroupId;
    private Object userId;

	public UserDatagroup(){
	}
    public void setDatagroupId(Integer value) {
        this.datagroupId = value;
    }

    public Integer getDatagroupId() {
        return this.datagroupId;
    }
    public void setUserId(Object value) {
        this.userId = value;
    }

    public Object getUserId() {
        return this.userId;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("DatagroupId",getDatagroupId())
			.append("UserId",getUserId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserDatagroup == false) return false;
		if(this == obj) return true;
		UserDatagroup other = (UserDatagroup)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

