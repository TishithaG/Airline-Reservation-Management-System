package com.example.airlinereservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airlinereservation.entity.AirlineInfo;


@Repository
public interface AirlineInfoDao extends JpaRepository<AirlineInfo, Integer> {
	
	AirlineInfo findByNameOfAirline(String name);
}


