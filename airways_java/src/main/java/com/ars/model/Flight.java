package com.ars.model;

public class Flight {

	private int flight_No;
	private String flight_Name;
	private String source;
	private String destination;
	private String takeoff_Time;
	private String landing_Time;
	private int business_Cost;
	private int economy_Cost;
	private int available_Tickets;
	private String travel_Date;
	private String id;

	public Flight(int flight_No, String flight_Name, String source, String destination, String takeoff_Time,
			String landing_Time, int business_Cost, int economy_Cost, int available_Tickets, String travel_Date,
			String id) {
		super();
		this.flight_No = flight_No;
		this.flight_Name = flight_Name;
		this.source = source;
		this.destination = destination;
		this.takeoff_Time = takeoff_Time;
		this.landing_Time = landing_Time;
		this.business_Cost = business_Cost;
		this.economy_Cost = economy_Cost;
		this.available_Tickets = available_Tickets;
		this.travel_Date = travel_Date;
		this.id = id;
	}

	public Flight() {
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

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTakeoff_Time() {
		return takeoff_Time;
	}

	public void setTakeoff_Time(String takeoff_Time) {
		this.takeoff_Time = takeoff_Time;
	}

	public String getLanding_Time() {
		return landing_Time;
	}

	public void setLanding_Time(String landing_Time) {
		this.landing_Time = landing_Time;
	}

	public int getBusiness_Cost() {
		return business_Cost;
	}

	public void setBusiness_Cost(int business_Cost) {
		this.business_Cost = business_Cost;
	}

	public int getEconomy_Cost() {
		return economy_Cost;
	}

	public void setEconomy_Cost(int economy_Cost) {
		this.economy_Cost = economy_Cost;
	}

	public int getAvailable_Tickets() {
		return available_Tickets;
	}

	public void setAvailable_Tickets(int available_Tickets) {
		this.available_Tickets = available_Tickets;
	}

	public String getTravel_Date() {
		return travel_Date;
	}

	public void setTravel_Date(String travel_Date) {
		this.travel_Date = travel_Date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}