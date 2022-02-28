package com.example.airlinereservation.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.airlinereservation.entity.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer>  {
	
	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	List<Flight> findByFlightInfoAirlineInfoNameOfAirlineAndFlightDate(String name, LocalDate flightDate);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	List<Flight> findByOriginAndFlightDate(String origin, LocalDate flightDate);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	List<Flight> getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(String origin, String destination,
			LocalDate flightDate);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	@Query(value = "from Flight f where f.origin= :origin and f.destination= :destination and f.flightDate= :flightDate and f.inventory.count >= :count order by f.fare.fare")
	List<Flight> getFlightsByOriginAndDestinationAndFlightDateOrderByFareFare(String origin, String destination,
			LocalDate flightDate, int count);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	List<Flight> findByFlightNumberAndOriginAndDestination(String flightNumber, String origin, String destination);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime);

	@EntityGraph(attributePaths = { "fare", "flightInfo", "inventory", "flightInfo.airlineInfo" })
	Flight findByOriginAndDestinationAndFlightDateAndFlightTime(String origin, String destination, LocalDate flightDate,
			LocalTime flightTime);
	

}
