package com.seth.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seth.FlightReservation.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
