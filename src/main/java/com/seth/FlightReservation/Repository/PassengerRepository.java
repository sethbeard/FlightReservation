package com.seth.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seth.FlightReservation.Entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
