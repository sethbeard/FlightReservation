package com.seth.FlightReservation.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.seth.FlightReservation.Entities.User;
import com.seth.FlightReservation.Repository.UserRepository;
import com.seth.FlightReservation.Services.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		LOGGER.info("Inside showLogin()");
		return "login/login";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user, ModelMap modelMap) {
		LOGGER.info("Inside register() + {user}");
		user.setPassword(encoder.encode(user.getPassword()));
		userRepos.save(user);
		String msg = "User " + user.getFirstName() + " " + user.getLastName() + " has been registered.";
		modelMap.addAttribute("msg", msg);
		return "login/login";
	}
	
	@RequestMapping(value= "/login",  method =RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		
		LOGGER.info("Inside login page + {email}");
		User user = userRepos.findByEmail(email);
		if (loginResponse) {
			return "findFlights";
		}
		String msg = "Invalid Email and Password Combination";
		modelMap.addAttribute("msg", msg);
		return "login/login";
		
	}
}
