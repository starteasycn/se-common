/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ucm
 * $Id:  Datagroup.java 2015-10-20 14:26:58 $
 */





package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.CreateBaseDomain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Datagroup extends CreateBaseDomain<Long>{
    private String name;
    /** 编码 */
    private String number;
    /** 描述 */
    private String description;
    /** 产品线 */
    private String product;

	public Datagroup(){
	}
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }
    public void setNumber(String value) {
        this.number = value;
    }

    public String getNumber() {
        return this.number;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }
    public void setProduct(String value) {
        this.product = value;
    }

    public String getProduct() {
        return this.product;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Number",getNumber())
			.append("Description",getDescription())
			.append("Status",getStatus())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Product",getProduct())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Datagroup == false) return false;
		if(this == obj) return true;
		Datagroup other = (Datagroup)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

