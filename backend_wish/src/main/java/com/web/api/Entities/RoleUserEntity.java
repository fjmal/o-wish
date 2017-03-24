package com.web.api.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_USER_ASS")
public class RoleUserEntity {

	@Id
	@Column(name = "ROLE_USER_ID", unique = true, nullable = false)
	private Integer roleUserId;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleEntity role;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	public Integer getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(Integer roleUserId) {
		this.roleUserId = roleUserId;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
