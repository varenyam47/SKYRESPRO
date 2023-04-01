package com.flightreservation.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where deparatureCity=:deparatureCity and arrivalCity=:arrivalCity and dateOfDeparature=:dateOfDeparature")
	List<Flight> findFlights(@Param("deparatureCity")String from,
			@Param("arrivalCity")String to,@Param("dateOfDeparature" )Date deparatureDate);

}
