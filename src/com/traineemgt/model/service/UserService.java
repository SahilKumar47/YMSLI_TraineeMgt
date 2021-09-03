package com.traineemgt.model.service;

import com.traineemgt.model.dao.user.User;

public interface UserService {
	public User getUser(String username, String password);
}