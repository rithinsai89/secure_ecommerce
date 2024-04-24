package com.ars.dao;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ars.model.Flight;

public class FlightDAOImpl {

	DB db = new DB();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(db.dataSource());

	Flight flight = null;

	public List<Flight> allFlights() {
		String sql = "select * from flight";
		return jdbcTemplate.query(sql, new FlightRowMapper());
	}

	public List<Flight> findFlightByName(String flight_Name) {
		String sql = "select * from flight where flight_Name ='" + flight_Name + "'";
		return jdbcTemplate.query(sql, new FlightRowMapper());
	}

	public Flight findFlightByNumber(int flight_No) {
		List<Flight> list = allFlights();
		for (Flight flight : list) {
			if (flight.getFlight_No() == flight_No) {
				return flight;
			}
		}
		return null;

	}

	public String addFlight(Flight flight) {
		String sql = "insert into flight(flight_Name, source, destination, takeoff_Time, landing_Time, business_Cost, economy_Cost,"
				+ " available_Tickets, travel_Date, id) values(?,?,?,?,?,?,?,?,?,?)";
		if (jdbcTemplate.update(sql,
				new Object[] { flight.getFlight_Name(), flight.getSource(), flight.getDestination(),
						flight.getTakeoff_Time(), flight.getLanding_Time(), flight.getBusiness_Cost(),
						flight.getEconomy_Cost(), flight.getAvailable_Tickets(), flight.getTravel_Date(),
						flight.getId() }) > 0) {
			return "Flight is added";
		}
		return "Failed";
	}

	

	public Object updateFlightDetailsByFlightNo(int flight_No, Flight flight) {

		String sqlSelect = "select * from Flight where Flight_No='" + flight_No + "'";
		if (jdbcTemplate.query(sqlSelect, new FlightRowMapper()) == null)
			return "not found";

		String sqlUpdate = "update Flight set Flight_Name = ?, Source = ?, Destination = ?, Takeoff_Time = ?, Landing_Time = ?, "
				+ "Business_Cost = ?, Economy_Cost = ?, Available_Tickets = ?, Travel_Date = ? where flight_No = ?";
		if ((jdbcTemplate.update(sqlUpdate, flight.getFlight_Name(), flight.getSource(), flight.getDestination(),
				flight.getTakeoff_Time(), flight.getLanding_Time(), flight.getBusiness_Cost(), flight.getEconomy_Cost(),
				flight.getAvailable_Tickets(), flight.getTravel_Date(), flight_No)) > 0)
			return "Flight updated";
		return "Failed to update Flight";

	}

	public boolean deleteFlight(int flight_No) {
		String sql = "delete from flight where flight_No = ?";
		if (jdbcTemplate.update(sql, new Object[] { flight_No }) > 0) {

			return true;// "Flight deleted";
		}
		return false;// "Failed to delete";
	}

	public List<Map<String, Object>> economyClass(String source, String destination, String travel_Date) {
		String sql = "select flight_No,flight_Name,source,destination,takeoff_Time,landing_Time,available_Tickets,economy_Cost from flight where "
				+ "source=? and destination=? and travel_Date=? order by economy_Cost";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				new Object[] { source, destination, travel_Date });

		return rows;
	}

	public List<Map<String, Object>> businessClass(String source, String destination, String travel_Date) {
		String sql = "select flight_No,flight_Name,source,destination,takeoff_Time,landing_Time,available_Tickets,business_Cost from flight where "
				+ "source=? and destination=? and travel_Date=? order by business_Cost";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				new Object[] { source, destination, travel_Date });

		return rows;
	}

	public List<Map<String, Object>> cities() {
		String sql = "select distinct source from flight order by source";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		return rows;
	}
	
	public List<Map<String, Object>> destinations() {
        System.out.println("destination");
        String sql = "select distinct destination from flight order by destination";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows;
    }


}
