package com.flightreservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.Flight;
import com.flightreservation.repositories.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from,
			@RequestParam("to")String to,
			@RequestParam("deparatureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date deparatureDate,ModelMap model) {
		      List<Flight> findFlights = flightRepo.findFlights(from , to , deparatureDate);
		      
		      model.addAttribute("findFlights", findFlights);
		      
			System.out.println(findFlights);
				return "displayFlights";
		}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId , ModelMap model) {
	Optional<Flight> findById = flightRepo.findById(flightId);
	Flight flight = findById.get();
	
		System.out.println(flight.getId());
		System.out.println(flight.getDeparatureCity());
		System.out.println(flight.getArrivalCity());
		System.out.println(flight.getFlightNumber());
		System.out.println(flight.getOperatingAirlines());
		System.out.println(flight.getEstimatedDeparatureTime());
	
	   model.addAttribute("flight", flight);
		return "showReservation";
	}

}
