package com.flightapp.tickets.dto;

import java.util.List;

import com.flightapp.flights.dto.FlightSchedule;

public class TicketResponseDto {

	private Ticket ticket;
	private FlightSchedule flight;
	private List<Passenger> passengers;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public FlightSchedule getFlight() {
		return flight;
	}
	public void setFlight(FlightSchedule flight) {
		this.flight = flight;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	@Override
	public String toString() {
		return "TicketResponseDto [ticket=" + ticket + ", flight=" + flight + ", passengers=" + passengers + "]";
	}
}
