package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.RoleDto;

@Service
public class StoryApplikation {

	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${backend.adress}")
	private String adress;
	
	@Autowired
	LoginApplikation loginapplication;
	
	
	
	public HttpStatusCode setStoryDone(Long id) {
		String url = adress.concat("/done/"+id);
		return restTemplate.postForEntity(url, null, null).getStatusCode();
	}
	
}
