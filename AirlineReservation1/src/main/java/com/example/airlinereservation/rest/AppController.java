package com.example.airlinereservation.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String homepage() {
		return "view/searchFlights";
	}

	@GetMapping("/login")
	public String login() {
		return "view/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "view/register";
	}
	
	@GetMapping("/bookFlight")
	public String bookFlight() {
		return "view/bookFlight";
	}
	

	@GetMapping("/checkin")
	public String checkinPage() {
		return "view/checkin";
		
	}

}
