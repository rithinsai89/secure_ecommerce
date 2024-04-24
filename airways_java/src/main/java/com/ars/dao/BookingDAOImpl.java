package com.ars.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.*;
import com.ars.model.BookingDetails;
import com.ars.model.TicketAndBookingDetails;

public class BookingDAOImpl {

	DB db = new DB();

	JdbcTemplate jdbcTemplate = new JdbcTemplate(db.dataSource());

	public boolean booking(BookingDetails book) {
		String sql = "insert into booking_details(class_Type,booking_Date,id,flight_No,passport_No,name,dob,gender,card_No,"
				+ "name_On_Card,type_Of_Payment, total_Amount) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int flightNo = book.getFlight_No();
		
		int lastTicketCount = jdbcTemplate.queryForObject(
				"select Available_Tickets from flight where Flight_No='" + flightNo + "'", Integer.class);
		
		int oneTicketMinus = lastTicketCount - 1;
		
		String sql2 = "update flight set Available_Tickets ='" + oneTicketMinus + "'where Flight_No='" + flightNo + "'";

		if (jdbcTemplate.update(sql,
				new Object[] { book.getClass_Type(), book.getBooking_Date().now(), book.getId(), book.getFlight_No(),
						book.getPassport_No(), book.getName(), book.getDob(), book.getGender(), book.getCard_No(),
						book.getName_On_Card(), book.getType_Of_Payment(), book.getTotal_Amount() }) > 0) {
			jdbcTemplate.update(sql2);
			return true;
		}
		return false;
	}

	public List<TicketAndBookingDetails> DisplayBookingDetails() {
		String sql = "select Booking_Details.Booking_Id,Flight.Flight_No,Flight.Flight_Name,Flight.Source,Flight.Destination,"
				+ "Flight.Takeoff_Time,Flight.Landing_Time,Flight.Travel_Date,Booking_Details.Passport_No, Booking_Details.Name, "
				+ "Booking_Details.DOB, Booking_Details.Gender, Booking_Details.Total_Amount,Booking_Details.Booking_Date,"
				+ "Booking_Details.Class_Type, User.Id from Flight join Booking_Details ON Flight.Flight_No = Booking_Details.Flight_No "
				+ "join User on User.Id = Booking_Details.Id ";
		return jdbcTemplate.query(sql, new TicketAndBookingDetailsMapper());
	}
	
	public List<TicketAndBookingDetails> getBookingDetailsByAirlines(List<String> airlines) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(db.dataSource());
		if (airlines == null || airlines.isEmpty()) {
            // Handle the case where the list is empty, for example, return an empty list
			return Collections.emptyList();
        }
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("flightCodes", airlines);
		String sql = "select BD.Booking_Id,F.Flight_No,F.Flight_Name,F.Source,F.Destination,"
				+ "F.Takeoff_Time,F.Landing_Time,F.Travel_Date,BD.Passport_No, BD.Name, "
				+ "BD.DOB, BD.Gender, BD.Total_Amount,BD.Booking_Date,"
				+ "BD.Class_Type, U.Id from Flight as F join Booking_Details as BD ON F.Flight_No = BD.Flight_No "
				+ "join User as U on U.Id = BD.Id "
				+ "where F.Flight_Name IN (:flightCodes)";
		return jdbcTemplate.query(sql, parameters, new TicketAndBookingDetailsMapper());
	}

	public TicketAndBookingDetails getTicketDetailsById(int booking_Id) {
		List<TicketAndBookingDetails> list = DisplayBookingDetails();
		for (TicketAndBookingDetails tbd : list) {
			if (tbd.getBooking_Id() == booking_Id) {
				return tbd;
			}
		}
		return null;
	}

	public Object DisplayBookingDetailsById(String id) {
		String sql = "select Booking_Details.Booking_Id,Flight.Flight_No,Flight.Flight_Name,Flight.Source,Flight.Destination,"
				+ "Flight.Takeoff_Time,Flight.Landing_Time,Flight.Travel_Date,Booking_Details.Passport_No, Booking_Details.Name, "
				+ "Booking_Details.DOB, Booking_Details.Gender, Booking_Details.Total_Amount,Booking_Details.Booking_Date,"
				+ "Booking_Details.Class_Type, User.Id from Flight join Booking_Details ON Flight.Flight_No = Booking_Details.Flight_No"
				+ " join User on User.Id = Booking_Details.Id where User.Id ='"
				+ id + "'";
		return jdbcTemplate.query(sql, new TicketAndBookingDetailsMapper());
	}

	
	public boolean cancelTicket(int booking_Id) {

		 

        int flightNo = jdbcTemplate.queryForObject(
                "select flight_No from booking_details where booking_Id='" + booking_Id + "'", Integer.class);
        int lastTicketCount = jdbcTemplate.queryForObject(
                "select Available_Tickets from flight where Flight_No='" + flightNo + "'", Integer.class);
        int oneTicketPlus = lastTicketCount + 1;

 

        String sql = "delete from booking_details where booking_Id=?";
        String sql2 = "update flight set Available_Tickets ='" + oneTicketPlus + "'where Flight_No='" + flightNo + "'";

 

        if (jdbcTemplate.update(sql, booking_Id) > 0) {
            jdbcTemplate.update(sql2);
            return true;// "Ticket is Cancelled Successfully";
        }
        return false;// "Failed To CancelTicket";
    }


	public List<Map<String, Object>> getBookingId(String id) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select booking_Id from booking_details where id=?",
				new Object[] { id });
		return rows;
	}

}
