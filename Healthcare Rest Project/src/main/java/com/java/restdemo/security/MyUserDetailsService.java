package com.java.restdemo.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.restdemo.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {


	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("searching for user name - " + userName);
		
		  com.java.restdemo.model.User user = userRepository.findByuserName(userName);
		  System.out.println("got user - " + user);
		  
		  if (user == null) { throw new UsernameNotFoundException("User '" + userName +
		  "' not found"); }
		  System.out.println("got user - " + user.getPassword());
		return new User(userName, user.getPassword(), new ArrayList<>());
		
	}
}
