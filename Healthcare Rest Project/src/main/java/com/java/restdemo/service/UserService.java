package com.java.restdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.restdemo.model.User;
import com.java.restdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		List<User> users = (List<User>) repo.findAll();
		return users;
	}

	public User findOne(int id) throws Exception {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new Exception("No user record exist for given id");
		}
	}

	public String registerUser(User user) throws Exception {
		String password = user.getPassword();
		if (password.isEmpty()) {
			throw new Exception("Invalid password.");
		}

		Optional<User> o_user = repo.findById(user.getUserId());

		if (o_user.isPresent()) {
			return "User Already Registered.";
		}

		repo.save(user);

		return "User Registered Successfully";
	}

	/*
	 * public User loadByUserName(String userName) throws Exception { User user =
	 * repo.findByUserName(userName);
	 * 
	 * if (user == null) { throw new
	 * UsernameNotFoundException(String.format("The username %s doesn't exist",
	 * user)); }
	 * 
	 * List<GrantedAuthority> authorities = new ArrayList()<>;
	 * user.getRoles().forEach(role -> { authorities.add(new
	 * SimpleGrantedAuthority(role.getRoleName())); });
	 * 
	 * UserDetails userDetails = new
	 * org.springframework.security.core.userdetails.User(user.getUsername(),
	 * user.getPassword(), authorities);
	 * 
	 * return userDetails; }
	 */

}
