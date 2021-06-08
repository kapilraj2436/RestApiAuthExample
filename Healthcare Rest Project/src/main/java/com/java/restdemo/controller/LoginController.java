package com.java.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.restdemo.config.JwtUtil;
import com.java.restdemo.model.Token;
import com.java.restdemo.model.User;
import com.java.restdemo.model.UserDTO;
import com.java.restdemo.repository.UserRepository;
import com.java.restdemo.security.MyUserDetailsService;
import com.java.restdemo.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

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

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) throws Exception {

		try {
			System.out.println("authantication started");
			System.out.println(authenticationRequest.getUsername() + "   " + authenticationRequest.getPassword());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			System.out.println("authantication completed");
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		System.out.println("loaded user");
		final String _token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new Token(_token));
	}

	@GetMapping(path = "/users")
	public List<User> getAllusers() throws Exception {
		System.out.println("in users");
		return service.findAll();
	}

}
