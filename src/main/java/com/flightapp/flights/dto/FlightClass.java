package com.flightapp.flights.dto;

public class FlightClass {
	private String name;
	private double fare;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	@Override
	public String toString() {
		return "FlightClass [name=" + name + ", fare=" + fare + "]";
	}
}
