package com.flightapp.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiController {
	
	//@Value("${airlineurl}") String airlineUrl;
	
	//private static RestTemplate template = new RestTemplate();

//	@GetMapping("/")
//	public List<AirlineDto> fetchAllAirlines() {
//		ResponseEntity<Object> airlines = template.exchange(airlineUrl, 
//				HttpMethod.GET, null, 
//				Object.class);
//		return (List<AirlineDto>) airlines.getBody();
//	}
	
	@GetMapping("/")
	private String some() {
		return "hello";
	}
	
	@GetMapping("/test")
	private String someTest() {
		System.out.println("Test");
		return "hello";
	}
}
