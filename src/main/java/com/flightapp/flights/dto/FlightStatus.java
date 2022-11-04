package com.flightapp.flights.dto;

public class FlightStatus {

	private int id;
	private String status;
	
	public FlightStatus() { }
	
	public FlightStatus(int id, String status) {
		this.id = id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FlightStatusRepo [id=" + id + ", status=" + status + "]";
	}
	
}
