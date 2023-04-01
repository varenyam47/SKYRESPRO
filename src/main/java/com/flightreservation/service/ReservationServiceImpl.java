package com.flightreservation.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entities.Flight;
import com.flightreservation.entities.Passenger;
import com.flightreservation.entities.Reservation;
import com.flightreservation.repositories.FlightRepository;
import com.flightreservation.repositories.PassengerRepository;
import com.flightreservation.repositories.ReservationRepository;
import com.flightreservation.utility.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		@SuppressWarnings("unused")
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		Reservation save = reservationRepo.save(reservation);
		
		PDFgenerator pdf = new PDFgenerator();
		String filePath = "C:\\Users\\admin\\itinery\\reservations"+save.getId()+".pdf";
		pdf.generateItinerary(reservation ,filePath);
		
		
		
//		pdf.generatePDF(filePath+reservation.getId()+".pdf", request.getFirstName(), request.getEmail(),
//				request.getPhone(), flight.getOperatingAirlines(), 
//				flight.getDateOfDeparature(), flight.getDeparatureCity(), flight.getArrivalCity());
		
		return save;
	}

}
