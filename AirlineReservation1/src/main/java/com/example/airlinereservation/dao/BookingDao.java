package com.example.airlinereservation.dao;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.airlinereservation.entity.BookingRecord;

@Repository
public interface BookingDao  extends JpaRepository<BookingRecord, Integer>{
	
	
	@Query( nativeQuery = true,  value = "select * from booking_record br where br.booking_id= 181")
	List<BookingRecord> getBookingRecordsByUserId(int userId);
	
	@EntityGraph(attributePaths = { "passengers" })
	BookingRecord findByBookingId(int bookingId);


}
