package com.java.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.restdemo.model.User;
import com.java.restdemo.service.UserService;


@RestController
public class LoginController {

	@Autowired
	UserService service;

	@PostMapping(path = "/user/register")
	public String register(@RequestBody User user) throws Exception {
		System.out.println("register user");
		String output = service.registerUser(user);
		return output;
	}
	
	@GetMapping(path = "/user/{userId}")
	public User getUser(@PathVariable("userId") int userId) throws Exception {

		User user = service.findOne(userId);
		return user;
	}
	
	@GetMapping(path = "/users")
	public List <User> getAllusers() throws Exception {
		System.out.println("in users");
		List<User> users = service.findAll();
		return users;
	}
	
	

}
