package com.nhon.spring.service;

import java.util.List;

import com.nhon.spring.models.User;

public interface UserService {

	public List<User> findAll();
	public User findUserById(int id);
	public boolean checkLogin(User user);
	public void register(User user);
}
