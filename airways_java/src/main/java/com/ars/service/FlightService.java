package com.ars.service;

import java.util.List;
import java.util.Map;

import com.ars.dao.FlightDAOImpl;
import com.ars.model.Flight;

public class FlightService {

	FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
	
	public List<Flight> allFlights() {
		return flightDAOImpl.allFlights();
	}
	
	public List<Flight> findFlightByName(String flight_Name) {
		return flightDAOImpl.findFlightByName(flight_Name);
	}
	
	public Flight findFlightByNumber(int flight_No) {
		return flightDAOImpl.findFlightByNumber(flight_No);
	}
	
	public String addFlight(Flight flight) {
		return flightDAOImpl.addFlight(flight);
	}
	
	/*public String updateFlight(int flight_No, Flight flight) {
		return flightDAOImpl.updateFlight(flight_No, flight);
	}*/
	
	public Object updateFlightDetailsByFlightNo(int flight_No, Flight flight) {
		return flightDAOImpl.updateFlightDetailsByFlightNo(flight_No,flight);
	}
	
	public boolean deleteFlight(int flight_No) {
		return flightDAOImpl.deleteFlight(flight_No);
	}
	
	public List<Map<String, Object>> economyClass(String source, String destination, String travel_Date) {
		return flightDAOImpl.economyClass(source, destination, travel_Date);
	}
	
	public List<Map<String, Object>> businessClass(String source, String destination, String travel_Date) {
		return flightDAOImpl.businessClass(source, destination, travel_Date);
	}
	
	public List<Map<String, Object>> cities(){
		return flightDAOImpl.cities();
	}
	
	public List<Map<String, Object>> destinations(){
		return flightDAOImpl.destinations();
	}
	
	/*public List<Map<String, Object>> eClass(Flight flight) {
		return flightDAOImpl.eClass(flight);
	}
	
	public List<Map<String, Object>> bClass(Flight flight) {
		return flightDAOImpl.bClass(flight);
	}*/
	
}
