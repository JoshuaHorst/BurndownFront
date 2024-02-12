package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.application.LoginApplikation;
import com.example.dto.LoginDto;
import com.example.dto.RoleDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = BurndownFrontApplication.class)
@AutoConfigureMockMvc
class BurndownFrontApplicationTests {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	LoginApplikation loginApplication;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	
	}
	@AfterEach
	public void tearDown() {
	  System.setOut(standardOut);

	}
	
	@Test
	void getRole() throws Exception {
		mvc.perform(get("/login/role/1"));
		String incoming = outputStreamCaptor.toString();
		String[] message = incoming.split("\n");
		Long id = Long.parseLong("1");
		RoleDto role = new RoleDto(id,"Projekt Manager","all");
		ObjectMapper mapper = new ObjectMapper();
		RoleDto result = mapper.readValue(message[0], RoleDto.class);
		assertThat(result.getId()).isEqualTo(role.getId());
	}
	
	
}
