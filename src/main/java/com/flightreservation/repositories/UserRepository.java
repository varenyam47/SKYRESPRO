package com.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByEmail(String emailid);

	

}
