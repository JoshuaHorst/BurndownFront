package com.example.dto;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LoginDto {

	
	private Long id;
	private Long roleId;
	private String roleName;
	private String permissions;
	private String name;
	private String birthday;


	public LoginDto(Long id, Long roleId, String roleName, String permissions, String name, String birthday) {
		this.id = id;
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissions = permissions;
		this.name = name;
		this.birthday = birthday;
	}
	

	
	public LoginDto( Long roleId, String roleName, String permissions, String name, String birthday) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissions = permissions;
		this.name = name;
		this.birthday = birthday;
	}
	
	public void toEnitity(String message) {}


	public LoginDto() {
		super();
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getPermissions() {
		return permissions;
	}


	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
		
}

