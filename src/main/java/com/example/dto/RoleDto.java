package com.example.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDto implements Serializable{
	
	
	private Long id;
	private String roleName;
	private String permissions;
	
	
	public RoleDto(Long id, String roleName, String permissions) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permissions = permissions;
	}
	
	public RoleDto() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getroleName() {
		return roleName;
	}
	public void setroleName(String name) {
		roleName = name;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	
}
