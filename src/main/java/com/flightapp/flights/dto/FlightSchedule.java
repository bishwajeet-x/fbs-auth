package com.flightapp.flights.dto;

import java.util.Collection;
import java.util.Date;

import com.flightapp.airlines.dto.AirlineResponseDto;

public class FlightSchedule {
	
	private String flightCode;
	private AirlineResponseDto airline;
	
	private Date sta;
	private Date eta;
	private int flightHours;
	
	private String source;
	private String destination;
	
	private Collection<FlightClass> flightClass;
	
	private FlightStatus status;

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public AirlineResponseDto getAirline() {
		return airline;
	}

	public void setAirline(AirlineResponseDto airline) {
		this.airline = airline;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public int getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(int flightHours) {
		this.flightHours = flightHours;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Collection<FlightClass> getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(Collection<FlightClass> flightClass) {
		this.flightClass = flightClass;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FlightSchedule [flightCode=" + flightCode + ", airline=" + airline + ", sta=" + sta + ", eta=" + eta
				+ ", flightHours=" + flightHours + ", source=" + source + ", destination=" + destination
				+ ", flightClass=" + flightClass + ", status=" + status + "]";
	}
}
