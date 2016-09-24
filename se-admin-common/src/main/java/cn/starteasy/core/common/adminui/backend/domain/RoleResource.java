/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  RoleResource.java 2014-10-03 16:39:53 $
 */



package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.CreateBaseDomain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RoleResource extends CreateBaseDomain<Long>{
    private Integer resourceId;
    private Integer resourceActionId;
    private Integer roleId;

	public RoleResource(){
	}
    public void setResourceId(Integer value) {
        this.resourceId = value;
    }

    public Integer getResourceId() {
        return this.resourceId;
    }
    public void setResourceActionId(Integer value) {
        this.resourceActionId = value;
    }

    public Integer getResourceActionId() {
        return this.resourceActionId;
    }
    public void setRoleId(Integer value) {
        this.roleId = value;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("ResourceId",getResourceId())
			.append("ResourceActionId",getResourceActionId())
			.append("RoleId",getRoleId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RoleResource == false) return false;
		if(this == obj) return true;
		RoleResource other = (RoleResource)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

