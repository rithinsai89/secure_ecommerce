package com.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ars.model.TicketAndBookingDetails;

public class TicketAndBookingDetailsMapper implements RowMapper<TicketAndBookingDetails> {
	
	public TicketAndBookingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TicketAndBookingDetails td = new TicketAndBookingDetails();
		td.setBooking_Id(rs.getInt("booking_Id"));
		td.setFlight_No(rs.getInt("flight_No"));
		td.setFlight_Name(rs.getString("flight_Name"));
		td.setSource(rs.getString("source"));
		td.setDestination(rs.getString("destination"));
		td.setTakeoff_Time(rs.getTime("takeoff_Time").toLocalTime());
		td.setLanding_Time(rs.getTime("landing_Time").toLocalTime());
		td.setTravel_Date(rs.getDate("travel_Date").toLocalDate());
		td.setPassport_No(rs.getString("passport_No"));
		td.setName(rs.getString("name"));
		td.setDob(rs.getDate("dob").toLocalDate());
		td.setGender(rs.getString("gender"));
		td.setTotal_Amount(rs.getInt("total_Amount"));
		td.setBooking_Date(rs.getString("booking_Date"));
		td.setClass_Type(rs.getString("class_Type"));
		td.setId(rs.getString("id"));
		return td;
		}
}
