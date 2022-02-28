package com.example.airlinereservation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.airlinereservation.dao.PassengerDao;
import com.example.airlinereservation.entity.Passenger;



@Service
public class PassengerService {
	
	@Lazy
	@Autowired
	private PassengerDao passengerDao;
	
	public List<Passenger> getAllPassengers() {
		return passengerDao.findAll();
	}
	
	
	public Passenger findById(int id) {
		return passengerDao.findById(id).get();
	}
	
	public void saveAll(List<Passenger> passengers) {
		passengerDao.saveAll(passengers);
	}
	
	public void save(Passenger passenger) {
		passengerDao.save(passenger);
	}

}
