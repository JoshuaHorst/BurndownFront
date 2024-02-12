package com.example.dto;

import java.util.Date;




public class SprintDto {
	
	private Long id;
	private Date start;
	private Date end;
	private UserDto creator;
	
	
	public SprintDto(Long id, Date start, Date end, UserDto creator) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.creator = creator;
	}
	
	public SprintDto() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public UserDto getCreator() {
		return creator;
	}

	public void setCreator(UserDto creator) {
		this.creator = creator;
	}
	
	
}
