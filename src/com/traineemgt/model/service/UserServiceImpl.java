package com.traineemgt.model.service;

import com.traineemgt.model.dao.user.User;
import com.traineemgt.model.dao.user.UserDao;
import com.traineemgt.model.dao.user.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
