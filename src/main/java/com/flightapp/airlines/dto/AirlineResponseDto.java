package com.flightapp.airlines.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.flightapp.api.dto.MealType;

public class AirlineResponseDto {
	
	private long airlineId;
	private String airlineName;
	private int noOfSeats;
	private boolean mealAvailable;
	private Collection<MealType> mealType = new ArrayList<>();
	private AirlineStatus airlineStatus;
	public AirlineResponseDto() {}

	public AirlineResponseDto(String airlineName, int noOfSeats, boolean mealAvailable,
			Collection<MealType> mealType, AirlineStatus airlineStatus) {
		this.airlineName = airlineName;
		this.noOfSeats = noOfSeats;
		this.mealAvailable = mealAvailable;
		this.mealType = mealType;
		this.airlineStatus = airlineStatus;
	}
	
	public AirlineResponseDto(AirlineDto dto) {
		this.airlineName = dto.getAirlineName();
		this.noOfSeats = dto.getNoOfSeats();
		this.mealAvailable = dto.isMealAvailable();
		this.airlineStatus = dto.getAirlineStatus();
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public boolean isMealAvailable() {
		return mealAvailable;
	}

	public void setMealAvailable(boolean mealAvailable) {
		this.mealAvailable = mealAvailable;
	}

	public Collection<MealType> getMealType() {
		return mealType;
	}

	public void setMealType(Collection<MealType> mealType) {
		this.mealType = mealType;
	}

	public AirlineStatus getAirlineStatus() {
		return airlineStatus;
	}

	public void setAirlineStatus(AirlineStatus airlineStatus) {
		this.airlineStatus = airlineStatus;
	}

	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", noOfSeats=" + noOfSeats
				+ ", mealAvailable=" + mealAvailable + ", mealType=" + mealType + ", airlineStatus=" + airlineStatus
				+ "]";
	}
}
