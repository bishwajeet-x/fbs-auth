package com.flightapp.airlines.dto;

public class AirlineStatus {
	
	private int id;
	private String status;
	
	public AirlineStatus() {}

	public AirlineStatus(int id, String status) {
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
		return "AirlineStatus [id=" + id + ", status=" + status + "]";
	}
	
	
}
