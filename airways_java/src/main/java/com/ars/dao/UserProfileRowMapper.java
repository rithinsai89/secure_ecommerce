package com.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ars.model.UserProfile;

public class UserProfileRowMapper implements  RowMapper<UserProfile>{

public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserProfile userProfile = new UserProfile();
		userProfile.setId(rs.getString("Id"));
		userProfile.setFirst_Name(rs.getString("First_Name"));
		userProfile.setLast_Name(rs.getString("Last_Name"));
		userProfile.setGender(rs.getString("Gender"));
		userProfile.setContact(rs.getLong("Contact"));
		
		return userProfile;
	}
}
