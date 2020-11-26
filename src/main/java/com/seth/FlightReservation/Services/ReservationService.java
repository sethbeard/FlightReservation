package com.seth.FlightReservation.Services;

import org.springframework.stereotype.Service;

import com.seth.FlightReservation.DTO.ReservationRequest;
import com.seth.FlightReservation.Entities.Reservation;

@Service
public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
