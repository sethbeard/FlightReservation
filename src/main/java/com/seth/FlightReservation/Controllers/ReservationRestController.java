package com.seth.FlightReservation.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seth.FlightReservation.DTO.ReservationUpdateRequest;
import com.seth.FlightReservation.Entities.Reservation;
import com.seth.FlightReservation.Repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	@Autowired
	ReservationRepository resRepos;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside Find Reservation for id: " + id);
		Reservation reservation = resRepos.findById(id).get();

		return reservation;
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest updateRequest) {
		LOGGER.info("Inside update Reservation() for id: " + updateRequest.getId());
		Reservation reservation = resRepos.findById(updateRequest.getId()).get();
		reservation.setCheckedIn(updateRequest.getCheckedIn());
		reservation.setNumberOfBags(updateRequest.getNumberOfBags());

		return resRepos.save(reservation);

	}

}
