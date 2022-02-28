package com.example.airlinereservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airlinereservation.entity.Passenger;


@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer>  {

}
