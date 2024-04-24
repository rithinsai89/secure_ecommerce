package com.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ars.model.BookingDetails;

public class BookingRowMapper implements RowMapper<BookingDetails>{

	public BookingDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		BookingDetails booking = new BookingDetails();
		booking.setBooking_Id(resultSet.getInt("booking_Id"));
		booking.setClass_Type(resultSet.getString("class_Type"));
		booking.setBooking_Date(resultSet.getDate("booking_Date").toLocalDate());
		booking.setPassport_No(resultSet.getString("passport_No"));
		booking.setName(resultSet.getString("name"));
		booking.setDob(resultSet.getString("dob"));
		booking.setGender(resultSet.getString("gender"));
		booking.setCard_No(resultSet.getString("card_No"));
		booking.setName_On_Card(resultSet.getString("name_On_Card"));
		booking.setType_Of_Payment(resultSet.getString("type_Of_Payment"));
		booking.setTotal_Amount(resultSet.getInt("total_Amount"));
		booking.setFlight_No(resultSet.getInt("flight_No"));
		booking.setId(resultSet.getString("id"));
		return booking;
	}
}
