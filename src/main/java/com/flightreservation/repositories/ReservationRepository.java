package com.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
