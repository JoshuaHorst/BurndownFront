package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.application.LoginApplikation;
import com.example.controller.RabbitListener;


@SpringBootApplication
@ComponentScan(basePackages={"com.example.controller","com.example.application","com.example.demo"})
public class BurndownFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurndownFrontApplication.class, args);
		
	}

}
