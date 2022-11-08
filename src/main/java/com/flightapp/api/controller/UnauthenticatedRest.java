package com.flightapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightapp.airlines.dto.AirlineResponseDto;
import com.flightapp.exception.SomethingWentWrong;
import com.flightapp.flights.dto.FlightSchedule;
import com.flightapp.flights.dto.FlightScheduleDto;
import com.flightapp.flights.dto.SearchFlightParams;

@RestController
@RequestMapping("/unauth/api")
public class UnauthenticatedRest {
	
	@Value("${airlineurl}") String airlineUrl;
	@Value("${ticketurl}") String ticketUrl;
	@Value("${flighturl}") String flightUrl;
	
	private static RestTemplate template = new RestTemplate();
	
	//get all flights
	@GetMapping("/flights")
	public ResponseEntity<List<FlightSchedule>> getAllFlight() {
		System.out.println("Inside getAllFlight");
		try {
			ResponseEntity<Object> response = template.exchange(flightUrl, HttpMethod.GET, null, Object.class);
			List<FlightSchedule> flights = (List<FlightSchedule>) response.getBody();
			return ResponseEntity.ok(flights);
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to create flight:: ", e);
		}
	}
	
	//search flights
	@PostMapping("/flights/search")
	public ResponseEntity<List<FlightSchedule>> searchFlights(@RequestBody SearchFlightParams request) {
		System.out.println("Inside searchFlights");
		String searchFlightUrl = flightUrl+"search";
		System.err.println(searchFlightUrl);
		try {
			HttpEntity<SearchFlightParams> requestEntity = new HttpEntity<SearchFlightParams>(request);
			ResponseEntity<Object> response = template.exchange(searchFlightUrl, HttpMethod.POST, requestEntity, Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), List.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrong("Failed to fetch flight!", e);
		}
	}
}
