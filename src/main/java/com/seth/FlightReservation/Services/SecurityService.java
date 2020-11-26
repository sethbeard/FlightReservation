package com.seth.FlightReservation.Services;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

	
	boolean login(String username, String password);
}
