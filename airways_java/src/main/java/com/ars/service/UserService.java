package com.ars.service;

import java.util.List;

import com.ars.dao.UserDAOImpl;
import com.ars.model.User;
import com.ars.model.UserProfile;

public class UserService {

	UserDAOImpl userDAOImpl = new UserDAOImpl();

	/* ---------------REGISTER--------------- */
	public String register(User user) {
		return userDAOImpl.register(user);
	}

	/* ---------------LOGIN--------------- */
	public String login(String id, String password, String user_Type) {
		return userDAOImpl.login(id, password, user_Type);
	}

	/* ---------------UpdatePassword--------------- */
	public String UpdatePassword(String id, String password) {
		// TODO Auto-generated method stub
		return userDAOImpl.UpdatePassword(id, password);
	}

	/* ---------------DISPLAY USER PROFILE--------------- */
	public List<UserProfile> userProfile(String id) {
		return userDAOImpl.userProfile(id);
	}

}
