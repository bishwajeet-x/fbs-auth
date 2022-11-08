package com.flightapp.tickets.dto;

public class Ticket {

	private long ticketId;
	
	private String flightId;
	private String name;
	private String email;
	private int numberOfSeats;
	private String meal;
	private String pnr;
	private Double fare;
	private String flightClass;
	private String status;
	private String username;
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", flightId=" + flightId + ", name=" + name + ", email=" + email
				+ ", numberOfSeats=" + numberOfSeats + ", meal=" + meal + ", pnr=" + pnr + ", fare=" + fare
				+ ", flightClass=" + flightClass + ", status=" + status + ", username=" + username + "]";
	}
}
