package com.flightapp.tickets.dto;

import java.util.List;

public class TicketDto {

	private long ticketId;
	private String name;
	private String gender;
	private int age;
	private String email;
	private String meal;
	private String flightId;
	private String pnr;
	private Double fare;
	private int numberOfSeats;
	private String flightClass;
	private List<Passenger> passengers;
	private String username;
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
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
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "TicketDto [ticketId=" + ticketId + ", name=" + name + ", gender=" + gender + ", age=" + age + ", email="
				+ email + ", meal=" + meal + ", flightId=" + flightId + ", pnr=" + pnr + ", fare=" + fare
				+ ", numberOfSeats=" + numberOfSeats + ", flightClass=" + flightClass + ", passengers=" + passengers
				+ ", username=" + username + "]";
	}
}
