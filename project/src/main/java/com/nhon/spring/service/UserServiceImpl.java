package com.nhon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhon.spring.models.User;
import com.nhon.spring.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	public List<User> findAll() {
		
		return this.userRepository.findAll();
	}

	public User findUserById(int id) {
		
		return this.findUserById(id);
	}

	public boolean checkLogin(User user) {
		
		return this.userRepository.checkLogin(user);
	}

	public void register(User user) {
		
		this.userRepository.register(user);
	}
	

}
