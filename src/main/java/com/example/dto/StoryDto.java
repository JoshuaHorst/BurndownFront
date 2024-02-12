package com.example.dto;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class StoryDto {

		
	
	
	
	public Long id;
	private String description;
	private UserDto creator;
	private UserDto assigne;
	private Long sprintbacklog;
	private Long produktbacklog;
	private int storypoints;
	private LocalDate creationDate;
	private LocalDate closingDate;
	private boolean done;
	
	
	
	
	public StoryDto(Long id, String description, UserDto creator, UserDto assigne, Long sprintbacklog,
			Long produktbacklog, int storypoints, LocalDate creationDate, LocalDate closingDate, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.creator = creator;
		this.assigne = assigne;
		this.sprintbacklog = sprintbacklog;
		this.produktbacklog = produktbacklog;
		this.storypoints = storypoints;
		this.creationDate = creationDate;
		this.closingDate = closingDate;
		this.done = done;
	}

	public StoryDto(Long id, String description, UserDto creator, Long sprintbacklog, Long produktbacklog, int storypoints,
			LocalDate creationDate, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.creator = creator;
		this.sprintbacklog = sprintbacklog;
		this.produktbacklog = produktbacklog;
		this.storypoints = storypoints;
		this.creationDate = creationDate;
		this.done = done;
	}
	
	public StoryDto(String description, UserDto creator, Long sprintbacklog, Long produktbacklog, int storypoints,
			LocalDate creationDate, boolean done) {
		super();
		this.description = description;
		this.creator = creator;
		this.sprintbacklog = sprintbacklog;
		this.produktbacklog = produktbacklog;
		this.storypoints = storypoints;
		this.creationDate = creationDate;
		this.done = done;
	}

	public StoryDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDto getCreator() {
		return creator;
	}

	public void setCreator(UserDto creator) {
		this.creator = creator;
	}

	public Long getSprintbacklog() {
		return sprintbacklog;
	}

	public void setSprintbacklog(Long sprintbacklog) {
		this.sprintbacklog = sprintbacklog;
	}

	public Long getProduktbacklog() {
		return produktbacklog;
	}

	public void setProduktbacklog(Long produktbacklog) {
		this.produktbacklog = produktbacklog;
	}

	public int getStorypoints() {
		return storypoints;
	}

	public void setStorypoints(int storypoints) {
		this.storypoints = storypoints;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public UserDto getAssigne() {
		return assigne;
	}

	public void setAssigne(UserDto assigne) {
		this.assigne = assigne;
	}
	
	
	
		
		
		

		
		
		
		
}
