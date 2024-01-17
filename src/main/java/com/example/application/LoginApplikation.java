package com.example.application;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.LoginDto;
import com.example.dto.RoleDto;

@Service
public class LoginApplikation {

	@Value("${backend.adress}")
	private String adress;
	
	private LoginDto logindata;
	
	RestTemplate restTemplate = new RestTemplate();
	
	public RoleDto getRolebyID(Long id){
	 String url = adress.concat("/role/get/"+id);
	 RoleDto role = restTemplate.getForObject(url, RoleDto.class);
	 System.out.println(restTemplate.getForObject(url, RoleDto.class).getId()+", ");
	 return role;
	}
	
	public LoginDto Login(Long id) {
		String url = adress.concat("/user/login/"+id);
		return logindata = restTemplate.getForObject(url, LoginDto.class);

	}

	public LoginDto getLogindata() {
		return logindata;
	}

	
	 
}