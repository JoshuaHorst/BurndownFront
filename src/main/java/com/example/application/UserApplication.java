package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.MessagePtoducerKafka;
import com.example.controller.RabbitSender;
import com.example.dto.LoginDto;
import com.example.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserApplication {

	@Autowired
	private RabbitSender rabbitSender;
	
    @Autowired
    private MessagePtoducerKafka messageProducer;
	
	
	public void createUser(UserDto dto) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(dto);
		message = message.concat("/user_create");
		rabbitSender.sender(message);
	}
	
	public void deleteUser(Long id) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(id.toString());
		message = message.concat("/user_delete");
		rabbitSender.sender(message);
	}
	
	public void updateUser(UserDto dto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(dto);
		message = message.concat("/user_update");
		rabbitSender.sender(message);
	}
	
	public void createUserKafka(UserDto dto) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(dto);
		message = message.concat("/user_create");
		messageProducer.sendMessage("my-topic-back", message);
	}
	
	public void deleteUserKafka(Long id) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(id.toString());
		message = message.concat("/user_delete");
		messageProducer.sendMessage("my-topic-back", message);
	}
	
	public void updateUserKafka(UserDto dto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String message = mapper.writeValueAsString(dto);
		message = message.concat("/user_update");
		messageProducer.sendMessage("my-topic-back", message);
	}
	
}
