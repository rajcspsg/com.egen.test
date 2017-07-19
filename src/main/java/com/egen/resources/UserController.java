package com.egen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entities.User;
import com.egen.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public HttpEntity<String> addUser(@RequestBody User user) {
		if(userService.addUser(user)) {
			return new ResponseEntity<String>("Sucessfully Added User", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("User already present in database", HttpStatus.ALREADY_REPORTED);
		}
	}
	
	@RequestMapping(path = "/getAllUsers", method = RequestMethod.GET)
	public HttpEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/updateUser", method = RequestMethod.POST)
	public HttpEntity<String> updateUser(@RequestBody User user) {
		if(userService.updateUser(user)) {
			return new ResponseEntity<String>("Sucessfully updated User", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("User is not present in database", HttpStatus.NOT_FOUND);
		}
	}
}
