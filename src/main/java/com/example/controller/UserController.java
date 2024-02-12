package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.UserApplication;
import com.example.dto.StoryDto;
import com.example.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserApplication userApplication;
	
	@PostMapping("create")
	public ResponseEntity<Void> createUser(@RequestBody UserDto user) throws JsonProcessingException{
		userApplication.createUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<Void> updateUser(@RequestBody UserDto user) throws JsonProcessingException{
		userApplication.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws JsonProcessingException {
		 
		userApplication.deleteUser(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	
	@PostMapping("kafka/create")
	public ResponseEntity<Void> createUserKafka(@RequestBody UserDto user) throws JsonProcessingException{
		userApplication.createUserKafka(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("kafka/update")
	public ResponseEntity<Void> updateUserKafka(@RequestBody UserDto user) throws JsonProcessingException{
		userApplication.updateUserKafka(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("kafka/delete/{id}")
	public ResponseEntity<Void> deleteUserKafka(@PathVariable Long id) throws JsonProcessingException {
		 
		userApplication.deleteUserKafka(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}


}
