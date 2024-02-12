package com.example.application;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.controller.MessagePtoducerKafka;
import com.example.controller.RabbitSender;
import com.example.dto.PersonalDataDto;
import com.example.dto.RoleDto;
import com.example.dto.SprintDto;
import com.example.dto.StoryDto;
import com.example.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Service
public class StoryApplikation {

	@Autowired
	LoginApplikation loginapplication;
	
    @Autowired
    private MessagePtoducerKafka messageProducer;
	
	@Autowired
	private RabbitSender rabbitSender;
	
	public void setStoryDone(Long id) {
		
		String message = id.toString()+"/story_done";
		rabbitSender.sender(message);
	}
	
	public void setStoryPoints(Long id, int points) {
		String message =id.toString()+ "%"+ points +"/story_points";
		rabbitSender.sender(message);
		
	}

	public void getByID(Long id) {
		String message = id.toString()+"/story_get";
		rabbitSender.sender(message);
		
	}

	public void updateStoryById(StoryDto story) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
    	String send = mapper.writeValueAsString(story);
		String message = send.concat("/story_update");
		rabbitSender.sender(message);
	}

	public void createStory(StoryDto story) throws JsonProcessingException {
		
		story.setCreationDate(LocalDate.now());
		RoleDto role = new RoleDto(loginapplication.getLogindata().getRoleId(), loginapplication.getLogindata().getRoleName(), loginapplication.getLogindata().getPermissions());
		PersonalDataDto data = new PersonalDataDto(loginapplication.getLogindata().getId(), loginapplication.getLogindata().getName(),loginapplication.getLogindata().getBirthday());
		UserDto creator = new UserDto(loginapplication.getLogindata().getId(), role, data);
		story.setCreator(creator);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
    	String send = mapper.writeValueAsString(story);
		String message = send+"/story_create";
		rabbitSender.sender(message);
		
	}
	
	public void geStoriesBySprit(Long sprintId) {
		String message = sprintId.toString();
		message = message.concat("/story-sprint");
		rabbitSender.sender(message);
	}
	
	public void setStoryDoneKafka(Long id) {
		
		String message = id.toString()+"/story_done";
		messageProducer.sendMessage("my-topic-back", message);
	}
	
	public void setStoryPointsKafka(Long id, int points) {
		String message =id.toString()+ "%"+ points +"/story_points";
		messageProducer.sendMessage("my-topic-back", message);
		
	}

	public void getByIDKafka(Long id) {
		String message = id.toString()+"/story_get";
		messageProducer.sendMessage("my-topic-back", message);
		
	}

	public void updateStoryByIdKafka(StoryDto story) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
    	String send = mapper.writeValueAsString(story);
		String message = send.concat("/story_update");
		messageProducer.sendMessage("my-topic-back", message);
	}

	public void createStoryKafka(StoryDto story) throws JsonProcessingException {
		
		story.setCreationDate(LocalDate.now());
		RoleDto role = new RoleDto(loginapplication.getLogindata().getRoleId(), loginapplication.getLogindata().getRoleName(), loginapplication.getLogindata().getPermissions());
		PersonalDataDto data = new PersonalDataDto(loginapplication.getLogindata().getId(), loginapplication.getLogindata().getName(),loginapplication.getLogindata().getBirthday());
		UserDto creator = new UserDto(loginapplication.getLogindata().getId(), role, data);
		story.setCreator(creator);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
    	String send = mapper.writeValueAsString(story);
		String message = send+"/story_create";
		messageProducer.sendMessage("my-topic-back", message);
		
	}
	
	public void geStoriesBySpritKafka(Long sprintId) {
		String message = sprintId.toString();
		message = message.concat("/story_sprint");
		messageProducer.sendMessage("my-topic-back", message);
	}
	
	public void printBurndown(String incoming) throws JsonMappingException, JsonProcessingException {
		String[] message = incoming.split("%");
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
		List<StoryDto> storyDto = new ArrayList();
		for(int i=0; i<message.length-1; i++) {
			storyDto.add(mapper.readValue(message[i], StoryDto.class));
		}
		SprintDto sprint = mapper.readValue(message[message.length-1], SprintDto.class);
		LocalDate start = sprint.getStart().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		LocalDate end = sprint.getEnd().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		List<Integer> points = new ArrayList();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		while(start.isBefore(end)) {
			int f = 0;
			for(int n =0; n<storyDto.size();n++ ) {
				
				if(start.isBefore(storyDto.get(n).getClosingDate())) {
				f = f+storyDto.get(n).getStorypoints();
				}
				
			}
			points.add(f);
			start = start.plusDays(1);
		}
		start = sprint.getStart().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		int x =0;
		while(start.plusDays(1).compareTo(end)<=1) {
			if(x<points.size()) {
			System.out.println("Am " + start + " müssen noch " +points.get(x)+" abgeschlossen werden" );
			}
			start = start.plusDays(1);
			x++;
		}
	}
}
