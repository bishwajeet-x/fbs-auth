package com.flightapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightapp.airlines.dto.AirlineDto;
import com.flightapp.airlines.dto.AirlineResponseDto;
import com.flightapp.api.dto.MealType;
import com.flightapp.entity._User;
import com.flightapp.exception.SomethingWentWrong;
import com.flightapp.flights.dto.FlightSchedule;
import com.flightapp.flights.dto.FlightScheduleDto;
import com.flightapp.service.UserService;

@RestController
@RequestMapping("/auth/api")
public class AuthenticatedRest {

	@Value("${airlineurl}") String airlineUrl;
	@Value("${ticketurl}") String ticketUrl;
	@Value("${flighturl}") String flightUrl;
	
	private static RestTemplate template = new RestTemplate();
	
	@Autowired private UserService userService;
	
	//get user by username
	@GetMapping("/users")
	public ResponseEntity<_User> fetchUserByUsername(@RequestParam ("username") String username) {
		return ResponseEntity.ok(userService.fetchUserByUsername(username));
	}
	
	//get all airlines
	@GetMapping("/airlines")
	public ResponseEntity<List<AirlineResponseDto>> fetchAllAirlines() {
		try {
			ResponseEntity<Object> response = template.exchange(airlineUrl, HttpMethod.GET, null,Object.class);
			List<AirlineResponseDto> airlines = (List<AirlineResponseDto>) response.getBody();
			return ResponseEntity.ok(airlines);
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to fetch airlines:: ", e);
		}
	}
	
	//get one airline
	@GetMapping("/airlines/search")
	public ResponseEntity<AirlineResponseDto> fetchAirlineById(@RequestParam("id") int airlineId) {
		String searchAirlineUrl = airlineUrl+"search?id="+airlineId;
		try {
			ResponseEntity<Object> response = template.exchange(searchAirlineUrl, HttpMethod.GET, null,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), AirlineResponseDto.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrong("Failed to fetch airline with id"+airlineId+":: ", e);
		}
	}
	
	//create airline
	@PostMapping("/airlines")
	public ResponseEntity<AirlineResponseDto> createAirlines(@RequestBody AirlineDto request) {
		try {
			HttpEntity<AirlineDto> requestEntity = new HttpEntity<AirlineDto>(request);
			ResponseEntity<Object> response = template.exchange(airlineUrl, HttpMethod.POST, requestEntity,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), AirlineResponseDto.class));
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to create airline:: ", e);
		}
	}
	
	//edit airline
	@PutMapping("/airlines")
	public ResponseEntity<AirlineResponseDto> editAirlines(@RequestBody AirlineDto request) {
		try {
			HttpEntity<AirlineDto> requestEntity = new HttpEntity<AirlineDto>(request);
			ResponseEntity<Object> response = template.exchange(airlineUrl, HttpMethod.PUT, requestEntity,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), AirlineResponseDto.class));
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to update airline:: ", e);
		}
	}
	
	//delete airline
	@DeleteMapping("/airlines")
	public ResponseEntity<Boolean> deleteAirline(@RequestParam("id") int airlineId) {
		String searchAirlineUrl = airlineUrl+"?id="+airlineId;
		try {
			ResponseEntity<Object> response = template.exchange(searchAirlineUrl, HttpMethod.DELETE, null,Object.class);
			Boolean airlines = (Boolean) response.getBody();
			return ResponseEntity.ok(airlines);
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to delete airline:: ", e);
		}
	}
	
	//change airline status
	@PutMapping("/airlines/status")
	public ResponseEntity<AirlineResponseDto> toggleStatus(@RequestBody AirlineDto airline) {
		String statusAirlineUrl = airlineUrl+"status";
		try {
			HttpEntity<AirlineDto> requestEntity = new HttpEntity<AirlineDto>(airline);
			ResponseEntity<Object> response = template.exchange(statusAirlineUrl, HttpMethod.PUT, requestEntity ,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), AirlineResponseDto.class));
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to delete airline:: ", e);
		}
	}
	
	@GetMapping("/airlines/mealTypes")
	public ResponseEntity<List<MealType>> getAllMealTypes() {
		try {
			ResponseEntity<Object> response = template.exchange(airlineUrl+"mealTypes", HttpMethod.GET, null,Object.class);
			List<MealType> meals = (List<MealType>) response.getBody();
			return ResponseEntity.ok(meals);
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to fetch airlines:: ", e);
		}
	}
	
	//create flights
	@PostMapping("/flights")
	public ResponseEntity<FlightSchedule> createFlight(@RequestBody FlightScheduleDto request) {
		try {
			HttpEntity<FlightScheduleDto> requestEntity = new HttpEntity<FlightScheduleDto>(request);
			ResponseEntity<Object> response = template.exchange(flightUrl, HttpMethod.POST, requestEntity,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), FlightSchedule.class));
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to create flight:: ", e);
		}
	}
	
	//change flight status
	@PutMapping("/flights/status")
	public ResponseEntity<FlightSchedule> changeStatus(@RequestBody FlightScheduleDto request) {
		flightUrl = flightUrl+"status";
		try {
			HttpEntity<FlightScheduleDto> requestEntity = new HttpEntity<FlightScheduleDto>(request);
			ResponseEntity<Object> response = template.exchange(flightUrl, HttpMethod.POST, requestEntity,Object.class);
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.ok(mapper.convertValue(response.getBody(), FlightSchedule.class));
		} catch (Exception e) {
			throw new SomethingWentWrong("Failed to change flight status:: ", e);
		}
	}
	
	//book tickets
	//ticket history
	//cancel ticket
	//search ticket
}
