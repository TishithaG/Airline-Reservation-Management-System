package com.example.airlinereservation.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.airlinereservation.dao.FlightDao;
import com.example.airlinereservation.entity.Flight;


@Service
public class FlightService {
	
	@Lazy
	@Autowired
	private FlightDao flightDao;

	public List<Flight> findByFlightInfoAirlineInfoNameOfAirlineAndFlightDate(String name, LocalDate flightDate) {
		return flightDao.findByFlightInfoAirlineInfoNameOfAirlineAndFlightDate(name, flightDate);
	}

	public List<Flight> findByOriginAndFlightDate(String origin, LocalDate flightDate) {
		return flightDao.findByOriginAndFlightDate(origin, flightDate);
	}

	public List<Flight> getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(String origin, String destination,
			LocalDate flightDate) {
		return flightDao.getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(origin, destination, flightDate);
	}

	public List<Flight> getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(String origin, String destination,
			LocalDate flightDate, int numberOfPassenger) {
		return flightDao.getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(origin, destination, flightDate,
				numberOfPassenger);
	}

	public List<Flight> findByFlightNumberAndOriginAndDestination(String flightNumber, String origin,
			String destination) {
		return flightDao.findByFlightNumberAndOriginAndDestination(flightNumber, origin, destination);
	}

	public Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime) {
		return flightDao.findByFlightNumberAndFlightDateAndFlightTime(flightNumber, flightDate, flightTime);
	}
	
	public List<Flight> saveAll(List<Flight> flights) {
		return flightDao.saveAll(flights);
	}

	public Flight saveFlight(Flight flight) {
		return flightDao.save(flight);
	}

	public Flight findByOriginAndDestinationAndFlightDateAndFlightTime(String origin, String destination,
			LocalDate flightDate, LocalTime flightTime) {
		return flightDao.findByOriginAndDestinationAndFlightDateAndFlightTime(origin, destination, flightDate,
				flightTime);
	}
	
	public List<Flight> findAll(){
		return flightDao.findAll();
	}


}
