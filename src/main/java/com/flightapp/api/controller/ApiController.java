package com.flightapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.api.dto.AirlineDto;

@RestController
@RequestMapping("/v1/api/airlines")
public class ApiController {
	
	@Value("${airlineurl}") String airlineUrl;
	
	private static RestTemplate template = new RestTemplate();

	@GetMapping("/")
	public List<AirlineDto> fetchAllAirlines() {
		ResponseEntity<Object> airlines = template.exchange(airlineUrl, 
				HttpMethod.GET, null, 
				Object.class);
		return (List<AirlineDto>) airlines.getBody();
	}
	
	@GetMapping("/test")
	private String some() {
		return "hello";
	}
}
