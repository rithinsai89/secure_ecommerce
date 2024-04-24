package com.ars.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus
;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ars.model.BookingDetails;
import com.ars.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ARS")
public class BookingController {

	BookingService bookingService = new BookingService();

    /*-------------------------Booking-------------------------*/
    
		// http://localhost:8090/ARS/booking
		@PostMapping("/booking")
		public ResponseEntity<String> booking(@RequestBody BookingDetails book) {
			try {
				if (bookingService.booking(book)) {
					return new ResponseEntity<String>("booking successful", HttpStatus.OK);
				}
				return new ResponseEntity<String>("booking failed", HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			return null;
		}

		/*--------------------DisplayBookingAndTicketDetails-------------------------*/

		// http://localhost:8090/ARS/DisplayAllBookingDetails
		@GetMapping("/DisplayAllBookingDetails")
		public ResponseEntity<Object> getBookingDetails() {

			try {
				return new ResponseEntity<>(bookingService.DisplayBookingDetails(), HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			return new ResponseEntity<>("Failed to get booking details", HttpStatus.BAD_REQUEST);
		}
		
		@PostMapping("/GetBookingDetailsByAirlines")
		public ResponseEntity<Object> getBookingDetailsByAirlines(@RequestBody  Map<String,List<String>> map) {
			List<String> flights = new ArrayList<String>();
			try {
				  flights = map.get("flights");
				  return new ResponseEntity<>(bookingService.GetBookingDetailsByAirlines(flights),HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			return new ResponseEntity<>("Failed to get booking details" +" "+ String.join(",", flights), HttpStatus.BAD_REQUEST);
		}

		// http://localhost:8090/ARS/DisplayBookingDetailsById/rk@gmail.com
		@GetMapping("/DisplayBookingDetailsById/{id}")
		public ResponseEntity<Object> DisplayBookingDetailsById(@PathVariable String id) {
			try {
				if ((bookingService.DisplayBookingDetailsById(id)) != null) {
					return new ResponseEntity<>(bookingService.DisplayBookingDetailsById(id), HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			return null;
		}

		// http://localhost:8090/ARS/DisplayTicketDetails/10000
		@GetMapping("/DisplayTicketDetails/{booking_Id}")
		public ResponseEntity<Object> getTicketDetailsById(@PathVariable int booking_Id) {
			try {
				if ((bookingService.getTicketDetailsById(booking_Id)) == null) {
					return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(bookingService.getTicketDetailsById(booking_Id), HttpStatus.OK);
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e);
			}
			return null;
		}

		/*---------------CancelTicket----------------*/
		@DeleteMapping("/CancelTicket/{booking_Id}")
		public ResponseEntity<Object> CancelTicket(@PathVariable int booking_Id) {

			try {
				if (bookingService.cancelTicket(booking_Id)) {
					return new ResponseEntity<>("Ticket has been cancelled successfully", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("No Ticket found with The Booking_Id" + "  " + booking_Id,
							HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			return null;
		}
		
		/*---------------DisplayBookingId----------------*/
		//http://localhost:8090/ARS/DisplayBookingId/jk@gmail.com
		@GetMapping("/DisplayBookingId/{id}")
		public ResponseEntity<Object> getBookingId(@PathVariable String id) {
			try {
				if (bookingService.getBookingId(id) != null) {
					return new ResponseEntity<>(bookingService.getBookingId(id), HttpStatus.OK);
				}
				return null;
			} catch (Exception e) {
				return new ResponseEntity<>("Invalid", HttpStatus.BAD_REQUEST);
			}
		}

	}