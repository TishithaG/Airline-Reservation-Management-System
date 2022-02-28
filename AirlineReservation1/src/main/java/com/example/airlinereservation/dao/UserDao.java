package com.example.airlinereservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airlinereservation.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	
	User findByUserName(String userName);

}
