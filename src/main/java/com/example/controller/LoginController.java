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
	public ResponseEntity<Void> getByRoleIdRabbitMQ(@PathVariable Long id) {
		 
		loginapplikation.getRoleByID(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
	
	
	@GetMapping("login/{id}")
	public ResponseEntity<Void> loginById(@PathVariable Long id) {
			loginapplikation.loginRequest(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Void> logout() {
		return new ResponseEntity<>(
			      null, loginapplikation.logout());
		
	}
	
	@GetMapping("kafka/role/{id}")
	public ResponseEntity<Void> getByRoleIdRabbitMQKafka(@PathVariable Long id) {
		 
		loginapplikation.getRoleByID(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
	
	
	@GetMapping("kafka/login/{id}")
	public ResponseEntity<Void> loginByIdKafka(@PathVariable Long id) {
			loginapplikation.loginRequest(id);
			return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	@GetMapping("kafka/logout")
	public ResponseEntity<Void> logoutKafka() {
		return new ResponseEntity<>(
			      null, loginapplikation.logout());
		
	}
	
}
