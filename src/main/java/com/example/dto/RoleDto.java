package com.example.dto;

import java.io.Serializable;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return roleName;
	}
	public void setName(String name) {
		roleName = name;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	
}
