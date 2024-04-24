package com.ars.model;

import java.time.LocalDate;

public class BookingDetails {

	private int booking_Id;
	private String class_Type;
	private LocalDate booking_Date;
	private String passport_No;
	private String name;
	private String dob;
	private String gender;
	private String card_No;
	private String name_On_Card;
	private String type_Of_Payment;
	private int total_Amount;
	private int flight_No;
	private String id;

	
	public BookingDetails(int booking_Id, String class_Type, LocalDate booking_Date, String passport_No, String name,
			String dob, String gender, String card_No, String name_On_Card, String type_Of_Payment, int total_Amount,
			int flight_No, String id) {
		super();
		this.booking_Id = booking_Id;
		this.class_Type = class_Type;
		this.booking_Date = booking_Date;
		this.passport_No = passport_No;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.card_No = card_No;
		this.name_On_Card = name_On_Card;
		this.type_Of_Payment = type_Of_Payment;
		this.total_Amount = total_Amount;
		this.flight_No = flight_No;
		this.id = id;
	}


	public BookingDetails() {}
	
	
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
	
	public LocalDate getBooking_Date() {
		return booking_Date;
	}
	public void setBooking_Date(LocalDate booking_Date) {
		this.booking_Date = booking_Date;
	}
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCard_No() {
		return card_No;
	}
	public void setCard_No(String card_No) {
		this.card_No = card_No;
	}
	public String getName_On_Card() {
		return name_On_Card;
	}
	public void setName_On_Card(String name_On_Card) {
		this.name_On_Card = name_On_Card;
	}
	public String getType_Of_Payment() {
		return type_Of_Payment;
	}
	public void setType_Of_Payment(String type_Of_Payment) {
		this.type_Of_Payment = type_Of_Payment;
	}
	public int getTotal_Amount() {
		return total_Amount;
	}
	public void setTotal_Amount(int total_Amount) {
		this.total_Amount = total_Amount;
	}
	public int getFlight_No() {
		return flight_No;
	}
	public void setFlight_No(int flight_No) {
		this.flight_No = flight_No;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
