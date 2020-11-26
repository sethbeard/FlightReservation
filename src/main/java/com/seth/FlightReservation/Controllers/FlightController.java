package com.seth.FlightReservation.Controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seth.FlightReservation.Entities.Flight;
import com.seth.FlightReservation.Repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightRepos;
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	
	@RequestMapping("/findFlight")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
		LOGGER.info("Inside findFlights()" + from + "To:"+ to + " date" + departureDate);
		
		List<Flight> flights =flightRepos.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flight Found:" + flights);
		return"displayFlights";
	}
	
	@RequestMapping("/admin/showAddFlight")
	public String showAddFlight() {
		return"addFlight";
	}

}
