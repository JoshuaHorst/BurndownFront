package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.application.StoryApplikation;
import com.example.dto.StoryDto;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("story")
public class StoryController {
	
	
	@Autowired
	StoryApplikation  storyApplikation;
	
	
	
	@GetMapping("done/{id}")
	public ResponseEntity<Void> setStoryDone(@PathVariable(value = "id") Long id) {
		storyApplikation.setStoryDone(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/points/{id}")
	public ResponseEntity<Void> setPointsByID(@PathVariable(value = "id") Long id, @RequestParam String p){
		
			storyApplikation.setStoryPoints(id, Integer.valueOf(p));
					
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Void> getStory(@PathVariable(value = "id") Long id){
		
		storyApplikation.getByID(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PostMapping("update")
	public ResponseEntity<Void> updateStory( @RequestBody StoryDto story) throws JsonProcessingException{
		
		storyApplikation.updateStoryById(story);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PostMapping("create")
	public ResponseEntity<Void> createStory(@RequestBody StoryDto story) throws JsonProcessingException{
		storyApplikation.createStory(story);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("kafka/done/{id}")
	public ResponseEntity<Void> setStoryDoneKafka(@PathVariable(value = "id") Long id) {
		storyApplikation.setStoryDoneKafka(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="kafka/points/{id}")
	public ResponseEntity<Void> setPointsByIDKafka(@PathVariable(value = "id") Long id, @RequestParam String p){
		
			storyApplikation.setStoryPointsKafka(id, Integer.valueOf(p));
					
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("kafka/get/{id}")
	public ResponseEntity<Void> getStoryKafka(@PathVariable(value = "id") Long id){
		
		storyApplikation.getByIDKafka(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PostMapping("kafka/update")
	public ResponseEntity<Void> updateStoryKafka( @RequestBody StoryDto story) throws JsonProcessingException{
		
		storyApplikation.updateStoryByIdKafka(story);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PostMapping("kafka/create")
	public ResponseEntity<Void> createStoryKafka(@RequestBody StoryDto story) throws JsonProcessingException{
		storyApplikation.createStoryKafka(story);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("get/sprint/{id}")
	public ResponseEntity<Void> getStorybySprint(@PathVariable(value = "id") Long id){
		
		storyApplikation.geStoriesBySprit(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("kafka/get/sprint/{id}")
	public ResponseEntity<Void> getStorybySprintKafka(@PathVariable(value = "id") Long id){
		
		storyApplikation.geStoriesBySpritKafka(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
