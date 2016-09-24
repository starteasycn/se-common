/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ucm
 * $Id:  DatagroupData.java 2015-10-21 09:36:45 $
 */




package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.CreateBaseDomain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DatagroupData extends CreateBaseDomain<Integer>{
	/** 数据权限model id */
	private Integer dataModelId;
	/** 对应id */
	private Object dataId;
	/** 数据组id */
	private Integer groupId;
	/** 数据维度 */
	private Integer dimension;

	public DatagroupData(){
	}
	public void setDataModelId(Integer value) {
		this.dataModelId = value;
	}

	public Integer getDataModelId() {
		return this.dataModelId;
	}
	public void setDataId(Object value) {
		this.dataId = value;
	}

	public Object getDataId() {
		return this.dataId;
	}
	public void setGroupId(Integer value) {
		this.groupId = value;
	}

	public Integer getGroupId() {
		return this.groupId;
	}
	public void setDimension(Integer value) {
		this.dimension = value;
	}

	public Integer getDimension() {
		return this.dimension;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("Id",getId())
				.append("Creator", getCreator())
				.append("CreateDate",getCreateDate())
				.append("LastModifier",getLastModifier())
				.append("LastModDate",getLastModDate())
				.append("Status",getStatus())
				.append("DataModelId",getDataModelId())
				.append("DataId",getDataId())
				.append("GroupId",getGroupId())
				.append("Dimension",getDimension())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof DatagroupData == false) return false;
		if(this == obj) return true;
		DatagroupData other = (DatagroupData)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}

