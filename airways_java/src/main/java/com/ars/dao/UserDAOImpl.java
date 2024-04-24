package com.ars.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ars.model.User;
import com.ars.model.UserProfile;

public class UserDAOImpl {

	DB db = new DB();

	JdbcTemplate jdbcTemplate = new JdbcTemplate(db.dataSource());

	/* ---------------REGISTER--------------- */
	public String register(User register) {

		String sql = "insert into User(Id,First_Name,Last_Name,Gender,Password,Contact,User_Type) values(?,?,?,?,?,?,'user')";
		System.out.println("sql query: " + sql + " firstName: " + register.getFirst_Name() + " lastName: "
				+ register.getLast_Name() + " gender: " + register.getGender() + " email: " + register.getId()
				+ " password: " + register.getPassword() + " contact: " + register.getContact());

		if (jdbcTemplate.update(sql, register.getId(), register.getFirst_Name(), register.getLast_Name(),
				register.getGender(), register.getPassword(), register.getContact()) > 0) {
			return "Registration Successful";
		}
		return "Failed";
	}

	/* ---------------LOGIN--------------- */
	public String login(String id, String password, String user_Type) {

		String sql = "select * from User where Id='" + id + "' and Password='" + password + "' and User_Type='"
				+ user_Type + "'";
		System.out.println("sql query: " + id);
		UserRowMapper lrm = new UserRowMapper();
		List<User> loginObj = jdbcTemplate.query(sql, lrm);

		if (loginObj.size() == 0) {
			return "Wrong Credentials";
		} else {
			return "Login Successful";
		}
	}

	/* ---------------UPDATE PASSWORD--------------- */
	public String UpdatePassword(String id, String password) {
		String sql = "update User set Password=? where Id=?";
		System.out.println("inside updatePassword()");
		if (jdbcTemplate.update(sql, password, id) > 0) {
			return "Password Updated";
		}
		return "No such user found";
	}

	/*--------DISPLAY USER PROFILE--------*/

	public List<UserProfile> userProfile(String id) {
		String sql = "select Id,First_Name,Last_Name,Gender,Contact from User where Id='" + id + "'";
		System.out.println("inside profile()");
		return jdbcTemplate.query(sql, new UserProfileRowMapper());
	}

	// public List<Map<String, Object>> userProfile(String id) {
	// List<Map<String, Object>> rows = jdbcTemplate.queryForList(
	// "select Id,First_Name,Last_Name,Gender,Contact from User where Id=?", new
	// Object[] { id });
	// System.out.println("inside userprofile()");
	// return rows;
	// }

}
