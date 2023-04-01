package com.flightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity{
	
	private String flightNumber;
	private String operatingAirlines;
	private String deparatureCity;
	private String arrivalCity;
	private Date dateOfDeparature;
	private Timestamp estimatedDeparatureTime;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingAirlines() {
		return operatingAirlines;
	}
	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}
	public String getDeparatureCity() {
		return deparatureCity;
	}
	public void setDeparatureCity(String deparatureCity) {
		this.deparatureCity = deparatureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public Date getDateOfDeparature() {
		return dateOfDeparature;
	}
	public void setDateOfDeparature(Date dateOfDeparature) {
		this.dateOfDeparature = dateOfDeparature;
	}
	public Timestamp getEstimatedDeparatureTime() {
		return estimatedDeparatureTime;
	}
	public void setEstimatedDeparatureTime(Timestamp estimatedDeparatureTime) {
		this.estimatedDeparatureTime = estimatedDeparatureTime;
	}

}
