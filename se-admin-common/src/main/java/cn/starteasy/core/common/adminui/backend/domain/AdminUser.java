/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ehr
 * $Id:  User.java 2014-09-26 10:33:05 $
 */



package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.UserDomain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 后台系统的专有模型
 */
public class AdminUser extends UserDomain<Long> implements UserDetails{
	//是否管理员
    private Integer isAdmin;
	//权限
	private Integer bizDimension;
    //
    private Integer employeeId;
    //产品线
	private String product;
	//真实姓名
	private String realName;
	//电子邮件
	private String email;
	//等同于 name
	private String login;


	//扩展字段可以添加想要的个性化属性
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public AdminUser(){
	}


	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setIsAdmin(Integer value) {
        this.isAdmin = value;
    }

    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    public void setEmployeeId(Integer value) {
        this.employeeId = value;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("IsAdmin", getIsAdmin())
			.append("Name",getName())
			.append("Password",getPassword())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("EmployeeId",getEmployeeId())
			.append("RealName",getRealName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AdminUser == false) return false;
		if(this == obj) return true;
		AdminUser other = (AdminUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getBizDimension() {
		return bizDimension;
	}

	public void setBizDimension(Integer bizDimension) {
		this.bizDimension = bizDimension;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

