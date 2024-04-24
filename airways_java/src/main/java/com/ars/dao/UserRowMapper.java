package com.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ars.model.User;


public class UserRowMapper implements  RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setId(rs.getString("Id"));
		user.setFirst_Name(rs.getString("First_Name"));
		user.setLast_Name(rs.getString("Last_Name"));
		user.setPassword(rs.getString("Password"));
		user.setGender(rs.getString("Gender"));
		user.setContact(rs.getLong("Contact"));
		user.setUser_Type(rs.getString("User_Type"));
		
		return user;
	}
	
}
