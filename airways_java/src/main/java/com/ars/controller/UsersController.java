package com.ars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ars.model.User;
import com.ars.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ARS")
public class UsersController {

	UserService userService = new UserService();

	/* ---------------LOGIN--------------- */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user) {
		System.out.println("Data received:  id: " + user.getId() + " password: " + user.getPassword() + "user_Type:"
				+ user.getUser_Type());

		try {
			String result = userService.login(user.getId(), user.getPassword(), user.getUser_Type());
			if (result.equals("Login Successful")) {
				return new ResponseEntity<>("Welcome to Airline Reservation System", HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
		return new ResponseEntity<>("UserId and password did not match", HttpStatus.NOT_FOUND);

	}

	/* ---------------REGISTER--------------- */
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user) {

		try {
			String result = userService.register(user);
			if (result.equals("Registration Successful")) {
				return new ResponseEntity<>("Registration Successful", HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
		return new ResponseEntity<>("Failed to register ", HttpStatus.NOT_FOUND);

	}

	/* ---------------Update Password--------------- */
	@PutMapping("/updatepassword")
	public ResponseEntity<Object> UpadatePassword(@RequestBody User user) {
		// System.out.println("The updated password for userID:"+ id+"is"+user);
		try {
			String result = userService.UpdatePassword(user.getId(), user.getPassword());
			if (result.equals("Password Updated")) {
				return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
		return new ResponseEntity<>("Failed to update password", HttpStatus.NOT_FOUND);
	}

	/*-------Display User Profile------*/
	// http://localhost:8090/ARS/userProfile/bindhu@gmail.com
	@GetMapping("/userProfile/{id}")
	public ResponseEntity<Object> userProfile(@PathVariable String id) {
		try {
			if (userService.userProfile(id) != null) {
				return new ResponseEntity<>(userService.userProfile(id), HttpStatus.OK);
			}
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>("Invalid", HttpStatus.BAD_REQUEST);
		}
	}
}

// @GetMapping("/userProfile/{id}")
// public ResponseEntity<Object>/* List<Map<String, Object>> */
// userProfile(@PathVariable String id) {
// try {
// return new ResponseEntity<>(userService.userProfile(id), HttpStatus.OK);
// } catch (Exception e) {
// System.out.println("Exception :" + e);
// }
// return null;
// }