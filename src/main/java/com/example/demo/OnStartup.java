package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.controller.RabbitListener;


@Component
public class OnStartup implements ApplicationListener<ApplicationStartedEvent> {
	
	@Autowired
	RabbitListener rabbitListener;

	
	
	@Override
	  public void onApplicationEvent(final ApplicationStartedEvent event) {
		  
		  rabbitListener.ReceiveTaskChangedNotificationRabbitMq();
	  }
	}
