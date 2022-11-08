package com.flightapp.tickets.dto;

public class TicketHistoryParam {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "TicketHistoryParam [username=" + username + "]";
	}
}
