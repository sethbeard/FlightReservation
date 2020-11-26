package com.seth.FlightReservation.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.seth.FlightReservation.DTO.ReservationRequest;
import com.seth.FlightReservation.Entities.Flight;
import com.seth.FlightReservation.Entities.Reservation;
import com.seth.FlightReservation.Repository.FlightRepository;
import com.seth.FlightReservation.Services.ReservationService;

@Controller
public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	FlightRepository flightRepos;
	
	@Autowired
	ReservationService reservationServ;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation" + flightId);
		Flight flight = flightRepos.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is" + flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside complete reservation" + request);
		Reservation reservation = reservationServ.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully.  Your reservation ID is " + reservation.getId());
		return"reservationConfirmation";
	}
	
}
