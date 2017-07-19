package com.egen.app.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.egen.app.UserTestsConfiguration;
import com.egen.entities.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserTestsConfiguration.class)
public class UserControllerTests {
	
	User user = new User("Raj", "Gounder", "Kumar", 28, 'M', 2345678910L, 02451);
	RestTemplate restTemplate = new RestTemplate();
	@Test
	public void testCreateUser() {
		//User user = new User("Raj", "Gounder", "Kumar", 28, 'M', 2345678910L, 02451);
		HttpEntity<User> request = new HttpEntity<User>(user);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/users/addUser", HttpMethod.POST, request, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("Sucessfully Added User", response.getBody());
		ResponseEntity<String> response2 = restTemplate.exchange("http://localhost:8080/users/addUser", HttpMethod.POST, request, String.class);
		Assert.assertEquals(HttpStatus.ALREADY_REPORTED, response.getStatusCode());
		Assert.assertEquals("User already present in database", response.getBody());
	}
	
	@Test
	public void testGetAllUsers() throws JSONException {
		ResponseEntity<String> jsonObject = restTemplate.getForEntity("http://localhost:8080/users/", String.class);
		//System.out.println("users are "+jsonObject.getBody());
		//Assert.assertEquals(users instanceof List<?>, true);
		JSONObject obj = new JSONObject(jsonObject.getBody());
		//System.out.println(obj.getJSONObject("_embedded"));
		Assert.assertEquals(obj.getJSONObject("_embedded").getJSONArray("users").length(), 1);
	}
	
	@Test
	public void testUpdateUser() throws JSONException {
		HttpEntity<User> request = new HttpEntity<User>(user);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/users/updateUser", HttpMethod.POST, request, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("Sucessfully updated User", response.getBody());
	}

}
