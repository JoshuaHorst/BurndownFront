package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.application.StoryApplikation;

@RestController
@RequestMapping("story")
public class StoryController {
	
	
	@Autowired
	StoryApplikation  storyApplikation;
	
	@GetMapping("done/{id}")
	public ResponseEntity<Void> setStoryDone(@PathVariable long id) {

			return new ResponseEntity<>(
				      null, storyApplikation.setStoryDone(id));
	}


}
