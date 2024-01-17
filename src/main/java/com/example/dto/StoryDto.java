package com.example.dto;

public class StoryDto {

		
		private Long id;
		private String description;
		private int storypoints;
		private boolean done;
		
		
		

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

		public int getStorypoints() {
			return storypoints;
		}


		public void setStorypoints(int storypoints) {
			this.storypoints = storypoints;
		}


		public boolean isDone() {
			return done;
		}


		public void setDone(boolean done) {
			this.done = done;
		}
		
}
