package com.nhon.spring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nhon.spring.models.User;

public class UserRepositoryImpl implements UserRepository {
	private static final Map<Integer, User> users;
	static {
		users = new HashMap<Integer, User>();
		users.put(1, new User("admin1","123456"));
		users.put(2, new User("staff1","12345"));
	}
	public User findUserById(int id) {
		User user = users.get(id);
		return user;
	}



	public boolean checkLogin(User user) {
		boolean isUser = false;
		for (User u : findAll()) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				isUser = true;
				break;
			}
		}
		return isUser;
		
	}
	public List<User> findAll() {
		
		return new ArrayList<User>(users.values());
	}
	public void register(User user) {
		int id = findAll().size();
		users.put(id + 1, user);
	
	}

}
