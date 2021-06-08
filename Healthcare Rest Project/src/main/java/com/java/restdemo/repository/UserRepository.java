package com.java.restdemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.restdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuserName(String userName);

	boolean existsByUserName(String userName);

	@Transactional
	void deleteByUserName(String userName);

}