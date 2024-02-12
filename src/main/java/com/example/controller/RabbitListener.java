package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.application.LoginApplikation;
import com.example.application.StoryApplikation;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class RabbitListener {
	
	@Autowired
	LoginApplikation loginApplication;
	
	@Autowired
	StoryApplikation storyApplication;
	
	private static final String EXCHANGE_NAME = "task_update_exchange_answer";
	
	 public void ReceiveTaskChangedNotificationRabbitMq() {
	        try { 
	            ConnectionFactory factory = new ConnectionFactory();
	            factory.setHost("localhost");
	            Connection connection = factory.newConnection();
	            Channel channel = connection.createChannel();
	            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
	            String queueName = channel.queueDeclare().getQueue();
	            channel.queueBind(queueName, EXCHANGE_NAME, "test_answer");
	            System.out.println("Waiting for messages.");
	            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	                String incoming = new String(delivery.getBody(), "UTF-8");
	                String[] message = incoming.split("/");
	                
	                
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
	                	System.out.println("This Story was set Done:/n");
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
	                
	            };
	            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
	        }
	        catch(Exception e) {
	            System.out.println("Fehler: "+ e);
	        }
	    }
}
