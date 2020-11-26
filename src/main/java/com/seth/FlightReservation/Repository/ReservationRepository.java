package com.seth.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seth.FlightReservation.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
