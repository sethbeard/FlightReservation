package com.seth.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seth.FlightReservation.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
