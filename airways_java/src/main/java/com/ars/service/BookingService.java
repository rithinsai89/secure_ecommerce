package com.ars.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ars.dao.BookingDAOImpl;
import com.ars.model.BookingDetails;

public class BookingService {

	BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();

	public boolean booking(BookingDetails book) {
		return bookingDAOImpl.booking(book);
	}
	
	public Object DisplayBookingDetails() {
		return bookingDAOImpl.DisplayBookingDetails();
	}
	
	public Object GetBookingDetailsByAirlines(List<String> airlines) {
		return bookingDAOImpl.getBookingDetailsByAirlines(airlines);
	}
	
	public Object getTicketDetailsById(int booking_Id) {
		return bookingDAOImpl.getTicketDetailsById(booking_Id);
	}

	public Object DisplayBookingDetailsById(String id) {
		return bookingDAOImpl.DisplayBookingDetailsById(id);
	}

	public boolean cancelTicket(int booking_Id) {
		return bookingDAOImpl.cancelTicket(booking_Id);
	}

	/*public List<Map<String, Object>>  BookingDetailsById(String id) {
		return bookingDAOImpl.BookingDetailsById(id);
	}*/
	public List<Map<String, Object>> getBookingId(String id) {
        return bookingDAOImpl.getBookingId(id);
    }

}
