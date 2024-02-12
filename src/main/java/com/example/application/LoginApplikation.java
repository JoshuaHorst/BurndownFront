package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.controller.MessagePtoducerKafka;
import com.example.controller.RabbitSender;
import com.example.dto.LoginDto;
import com.example.dto.RoleDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class LoginApplikation {
	
	private LoginDto logindata;
	
	@Autowired
	private RabbitSender rabbitSender;
	
    @Autowired
    private MessagePtoducerKafka messageProducer;
	
	
	public void getRoleByID(Long id) {
		String message = id.toString()+"/role_by_id";
		rabbitSender.sender(message);
		    }
	
	
	public void updateRole(RoleDto roleDto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(roleDto);
		message = message.concat("/role_update");
		rabbitSender.sender(message);
		    }
	
	public void deleteRole(Long id) {
		String message = id.toString()+"/role_delete";
		rabbitSender.sender(message);
		    }
	
	public void createRole(RoleDto roleDto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(roleDto);
		message = message.concat("/role_create");
		rabbitSender.sender(message);
		    }
	
	public void loginRequest(Long id) {
		String message = id.toString()+"/user_login";
		rabbitSender.sender(message);

	}
	
	public void loginAnswer(String message) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		LoginDto login = mapper.readValue(message, LoginDto.class);
		logindata = login;
		System.out.println("Logged in as: "+ logindata.getName());
	}
	
	public HttpStatusCode logout() {
		
		logindata = null;
		return HttpStatus.OK;
	}

	public LoginDto getLogindata() {
		return logindata;
	}
	
	public void getRoleByIDKafka(Long id) {
		String message = id.toString()+"/role_by_id";
		messageProducer.sendMessage("my-topic-back", message);
		    }
	
	
	public void updateRoleKafka(RoleDto roleDto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(roleDto);
		message = message.concat("/role_update");
		messageProducer.sendMessage("my-topic-back", message);
		    }
	
	public void deleteRoleKafka(Long id) {
		String message = id.toString()+"/role_delete";
		messageProducer.sendMessage("my-topic-back", message);
		    }
	
	public void createRoleKafka(RoleDto roleDto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(roleDto);
		message = message.concat("/role_create");
		messageProducer.sendMessage("my-topic-back", message);
		    }
	
	public void loginRequestKafka(Long id) {
		String message = id.toString()+"/user_login";
		System.out.println(message);
		messageProducer.sendMessage("my-topic-back", message);

	}

	public LoginDto getLogindataKafka() {
		return logindata;
	}
	
	 
}