package com.example.airlinereservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlineInfo")
public class AirlineInfo {
	
	@Id
	@GeneratedValue
	private int airlineId;
	
	private String nameOfAirline;

	public AirlineInfo() {
		super();
	}
	
	public AirlineInfo(int airlineId, String nameOfAirline) {
		super();
		this.airlineId = airlineId;
		this.nameOfAirline = nameOfAirline;
	}
	
	public AirlineInfo(String nameOfAirline) {
		super();
		this.nameOfAirline = nameOfAirline;
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getNameOfAirline() {
		return nameOfAirline;
	}

	public void setNameOfAirline(String nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}

	@Override
	public String toString() {
		return "AirlineInfo [airlineId=" + airlineId + ", nameOfAirline=" + nameOfAirline + "]";
	}

}
