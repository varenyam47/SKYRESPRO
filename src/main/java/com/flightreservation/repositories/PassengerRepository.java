package com.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
