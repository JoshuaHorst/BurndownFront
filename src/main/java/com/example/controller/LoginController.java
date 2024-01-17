package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.LoginApplikation;
import com.example.dto.LoginDto;
import com.example.dto.RoleDto;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	LoginApplikation  loginapplikation;
	
	@GetMapping("role/{id}")
	public ResponseEntity<RoleDto> getByRoleId(@PathVariable long id) {
		
		RoleDto role = loginapplikation.getRolebyID(id);
		
		if(role != null) {
			return new ResponseEntity<>(
				      role, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(
				      null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("login/{id}")
	public ResponseEntity<LoginDto> loginById(@PathVariable long id) {
		
		LoginDto role = loginapplikation.Login(id);
		
		if(role != null) {
			return new ResponseEntity<>(
				      role, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(
				      null, HttpStatus.BAD_REQUEST);
		}
		
	}
}
