package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.application.LoginApplikation;
import com.example.application.StoryApplikation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class KafkaConsumer {
	
	@Autowired
	LoginApplikation loginApplication;
	
	@Autowired
	StoryApplikation storyApplication;
    

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String Incoming) throws JsonMappingException, JsonProcessingException {
        System.out.println("Received message: " + Incoming);
        
        String[]message = Incoming.split("/");
        

        
        if(message[1].equals("role_by_id") == true) {
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("role_update") == true) {
        	System.out.println("The role has been Updated to: \n");
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("role_delete") == true) {
        	System.out.println(message[0]);
        }
        
        
        if(message[1].equals("role_create") == true) {
        	System.out.println("The role has been created to: \n");
        	System.out.println(message[0]);;
        }
        
        if(message[1].equals("backlog_create") == true) {
        	System.out.println("The backlog has been created to: \n");
        	System.out.println(message[0]);;
        }
        
        if(message[1].equals("backlog_delete") == true) {
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("user_delete") == true) {
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("user_create") == true) {
        	System.out.println("The user has been created: \n");
        	System.out.println(message[0]);;
        }
        
        if(message[1].equals("user_update") == true) {
        	System.out.println("The user has been updated: \n");
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("user_login") == true) {
        	loginApplication.loginAnswer(message[0]);
        }
        
        if(message[1].equals("sprint_create") == true) {
        	System.out.println("The sprint has been created to: \n");
        	System.out.println(message[0]);;
        }
        
        if(message[1].equals("story_points") == true) {
        	System.out.println("The points on this Story: \n" +message[0]+  "\n have been changed");
        }
        
        
        if(message[1].equals("story_done") == true) {
        	System.out.println("The Storypoints have been updated to: \n");
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("story_get") == true) {
        	System.out.println("You requested this Story:" );
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("story_create") == true) {
        	System.out.println("The story has been created: \n");
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("story_update") == true) {
        	System.out.println("The story has been updated to: \n");
        	System.out.println(message[0]);
        }
        
        if(message[1].equals("story_sprint") == true) {
        	storyApplication.printBurndown(message[0]);
        }
    }

}