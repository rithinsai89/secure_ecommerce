package com.ars.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ars.model.Flight;

public class FlightRowMapper implements RowMapper<Flight>{


public Flight mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Flight flight = new Flight();
		flight.setFlight_No(resultSet.getInt("flight_No"));
		flight.setFlight_Name(resultSet.getString("flight_Name"));
		flight.setSource(resultSet.getString("source"));
		flight.setDestination(resultSet.getString("destination"));
		flight.setTakeoff_Time(resultSet.getString("takeoff_Time"));
		flight.setLanding_Time(resultSet.getString("landing_Time"));
		flight.setBusiness_Cost(resultSet.getInt("business_Cost"));
		flight.setEconomy_Cost(resultSet.getInt("economy_Cost"));
		flight.setAvailable_Tickets(resultSet.getInt("available_Tickets"));
		flight.setTravel_Date(resultSet.getString("travel_Date"));
		flight.setId(resultSet.getString("id"));
		return flight;
	}
}
