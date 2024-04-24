package com.ars.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketAndBookingDetails {
		
		
		private int booking_Id;
		private int flight_No;
		private String flight_Name;
		private String source;
		private String destination;
		private LocalTime takeoff_Time;
		private LocalTime landing_Time;
		private LocalDate travel_Date;
		private String passport_No;
		private String name;
		private LocalDate dob;
		private String gender;
		private int total_Amount;
		private String booking_Date;
		private String class_Type;
		private String id;
			
		
		

		

		public TicketAndBookingDetails(int booking_Id, int flight_No, String flight_Name, String source, String destination,
				LocalTime takeoff_Time, LocalTime landing_Time, LocalDate travel_Date, String passport_No, String name,
				LocalDate dob, String gender, int total_Amount, String booking_Date, String class_Type, String id) {
			super();
			this.booking_Id = booking_Id;
			this.flight_No = flight_No;
			this.flight_Name = flight_Name;
			this.source = source;
			this.destination = destination;
			this.takeoff_Time = takeoff_Time;
			this.landing_Time = landing_Time;
			this.travel_Date = travel_Date;
			this.passport_No = passport_No;
			this.name = name;
			this.dob = dob;
			this.gender = gender;
			this.total_Amount = total_Amount;
			this.booking_Date = booking_Date;
			this.class_Type = class_Type;
			this.id = id;
		}
		
		public TicketAndBookingDetails() {}

		
		public String getPassport_No() {
			return passport_No;
		}

		public void setPassport_No(String passport_No) {
			this.passport_No = passport_No;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
			public int getFlight_No() {
			return flight_No;
		}
		public void setFlight_No(int flight_No) {
			this.flight_No = flight_No;
		}
		
		
		
		public String getFlight_Name() {
			return flight_Name;
		}


		public void setFlight_Name(String flight_Name) {
			this.flight_Name = flight_Name;
		}


		public String getSource() {
			return source;
		}
		public void setSource(String Source) {
			this.source = Source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public LocalTime getTakeoff_Time() {
			return takeoff_Time;
		}
		public void setTakeoff_Time(LocalTime takeoff_Time) {
			this.takeoff_Time = takeoff_Time;
		}
		public LocalTime getLanding_Time() {
			return landing_Time;
		}
		public void setLanding_Time(LocalTime landing_Time) {
			this.landing_Time = landing_Time;
		}
		public LocalDate getTravel_Date() {
			return travel_Date;
		}
		public void setTravel_Date(LocalDate travel_Date) {
			this.travel_Date = travel_Date;
		}
		public int getTotal_Amount() {
			return total_Amount;
		}
		public void setTotal_Amount(int total_Amount) {
			this.total_Amount = total_Amount;
		}
		public String getBooking_Date() {
			return booking_Date;
		}
		public void setBooking_Date(String booking_Date) {
			this.booking_Date = booking_Date;
		}
		public int getBooking_Id() {
			return booking_Id;
		}
		public void setBooking_Id(int booking_Id) {
			this.booking_Id = booking_Id;
		}
		public String getClass_Type() {
			return class_Type;
		}
		public void setClass_Type(String class_Type) {
			this.class_Type = class_Type;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}
		
			
		


}
