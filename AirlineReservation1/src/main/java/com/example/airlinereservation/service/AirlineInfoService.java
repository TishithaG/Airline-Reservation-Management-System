package com.example.airlinereservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.airlinereservation.dao.AirlineInfoDao;
import com.example.airlinereservation.entity.AirlineInfo;



@Service
public class AirlineInfoService {
	
	@Lazy
	@Autowired
	private AirlineInfoDao airlineInfoDao;
	

	public AirlineInfo findByNameOfAirline(String name) {
		return airlineInfoDao.findByNameOfAirline(name);
	}


}
