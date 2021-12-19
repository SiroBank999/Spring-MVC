package com.nhon.spring.repository;

import java.util.List;

import com.nhon.spring.models.User;

public interface UserRepository {

	public List<User> findAll();
	public User findUserById(int id);
	public boolean checkLogin(User user);
	public void register(User user);
}
