package com.seth.FlightReservation.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seth.FlightReservation.DTO.ReservationRequest;
import com.seth.FlightReservation.Entities.Flight;
import com.seth.FlightReservation.Entities.Passenger;
import com.seth.FlightReservation.Entities.Reservation;
import com.seth.FlightReservation.Repository.FlightRepository;
import com.seth.FlightReservation.Repository.PassengerRepository;
import com.seth.FlightReservation.Repository.ReservationRepository;
import com.seth.FlightReservation.util.EmailUtil;
import com.seth.FlightReservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Value("${com.seth.FlightReservation.itinerary.dirpath")
	private  String ITINERARY_DIR;
	@Autowired
	FlightRepository flightRepos;
	@Autowired
	PassengerRepository passRepos;
	@Autowired
	ReservationRepository resRepos;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	
	@Autowired
	PDFGenerator pdfGeneration;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		//Make Payment
	
		long flightId = request.getFlightId();
		LOGGER.info("Fetching "+ flightId + "inside bookFlight()");
		Flight flight = flightRepos.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setEmail(request.getPassengerEmail());
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving Passenger: " + passenger);
		Passenger savedPass = passRepos.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPass);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving reservation: " + reservation);
		Reservation save = resRepos.save(reservation);
		
		String filePath = ITINERARY_DIR + save.getId() +".pdf";
		pdfGeneration.generateItinearay(reservation, filePath  );
		LOGGER.info("generating pdf");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		LOGGER.info("sending email");
		return save;
	}

}
