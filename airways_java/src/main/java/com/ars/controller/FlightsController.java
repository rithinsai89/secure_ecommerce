package com.ars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ars.model.Flight;
import com.ars.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ARS")
public class FlightsController {

	FlightService flightService = new FlightService();

	/* ---------------FLIGHT--------------- */
	@GetMapping("/flights")
	public ResponseEntity<Object> /* List<Flight> */ allFlights() {
		try {
			return new ResponseEntity<>(flightService.allFlights(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	/*
	 * @GetMapping("/getFlightByName") public List<Flight>
	 * flightByName(@RequestParam String flight_Name) { return
	 * flightService.findFlightByName(flight_Name); }
	 */

	@GetMapping("/getFlightByNumber/{flight_No}")
	public ResponseEntity<Object> flightByNumber(@PathVariable int flight_No) {
		try {
			if (flightService.findFlightByNumber(flight_No) != null) {
				return new ResponseEntity<>(flightService.findFlightByNumber(flight_No), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	@PostMapping("/addFlight")
	public ResponseEntity<Object> addFlight(@RequestBody Flight flight) {
		try {

			if (flightService.addFlight(flight) != null) {
				return new ResponseEntity<>("Flight is added Successfully", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Failed to add Flight", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// http://localhost:8090/FLIGHT_CRUD/updateFlightDetails/101
	@PutMapping(path = "/updateFlightDetails/{flight_No}")
	public ResponseEntity<Object> updateFlightDetailsBy(@PathVariable int flight_No, @RequestBody Flight flight) {
		try {
			if ((flightService.updateFlightDetailsByFlightNo(flight_No, flight)) == null) {
				return new ResponseEntity<>("Flight data not found", HttpStatus.NOT_FOUND);

			} else {
				return new ResponseEntity<>(flightService.updateFlightDetailsByFlightNo(flight_No, flight),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	@DeleteMapping("/cancelFlight/{flight_No}")
	public ResponseEntity<Object> deleteFlight(@PathVariable int flight_No) {
		try {
			if (flightService.deleteFlight(flight_No)) {
				return new ResponseEntity<>("Flight is cancelled", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Failed to cancel Flight", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	/* -------- Show Available Flights -------- */
	@GetMapping("/economyClass")
	public ResponseEntity<Object> economyClass(@RequestParam String source, @RequestParam String destination,
			@RequestParam String travel_Date) {
		try {
			if (flightService.economyClass(source, destination, travel_Date) != null) {
				return new ResponseEntity<>(flightService.economyClass(source, destination, travel_Date),
						HttpStatus.OK);
			}
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/businessClass")
	public ResponseEntity<Object> businessClass(@RequestParam String source, @RequestParam String destination,
			@RequestParam String travel_Date) {
		try {
			if (flightService.businessClass(source, destination, travel_Date) != null) {
				return new ResponseEntity<>(flightService.businessClass(source, destination, travel_Date),
						HttpStatus.OK);
			}
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/cities")
	public ResponseEntity<Object> cities() {
		try {
			if (flightService.cities() != null) {
				return new ResponseEntity<>(flightService.cities(), HttpStatus.OK);
			}
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/destination")
	public ResponseEntity<Object> destinations() {
		try {
			if (flightService.destinations() != null) {
				return new ResponseEntity<>(flightService.destinations(), HttpStatus.OK);
			}
			return null;
		} catch (Exception e) {
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		}
	}

	/* -------- Show Available Flights -------- */
	/*
	 * @PutMapping("/eClass") public List<Map<String, Object>> eClass(@RequestBody
	 * Flight flight) { return flightService.eClass(flight); }
	 * 
	 * @PutMapping("/bClass") public List<Map<String, Object>> bClass(@RequestBody
	 * Flight flight) { return flightService.bClass(flight); }
	 */

	/*
	 * @DeleteMapping("/deleteFlight/{flight_No}") public String
	 * deleteFlight(@PathVariable int flight_No) { return
	 * flightService.deleteFlight(flight_No); }
	 */

}
