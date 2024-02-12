package com.example.controller;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


@Component
public class RabbitSender {
private static final String EXCHANGE_NAME = "task_update_exchange";
	
	
	
	public void sender(String message) {
		   ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    try (Connection connection = factory.newConnection();
		         Channel channel = connection.createChannel()) {
		  
		        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		        channel.basicPublish(EXCHANGE_NAME, "test", null, message.getBytes("UTF-8"));
				}catch(Exception e){
					System.out.println("failure");
				}
		    }
}
