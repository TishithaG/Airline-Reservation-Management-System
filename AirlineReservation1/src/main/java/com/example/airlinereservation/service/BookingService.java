package com.example.airlinereservation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.airlinereservation.dao.BookingDao;
import com.example.airlinereservation.entity.BookingRecord;
import com.example.airlinereservation.entity.Checkin;
import com.example.airlinereservation.entity.Flight;
import com.example.airlinereservation.entity.Passenger;
import com.example.airlinereservation.entity.User;


@Service
public class BookingService {
	
	@Lazy
	@Autowired
	private BookingDao bookingDao;

	@Lazy
	@Autowired
	private PassengerService passengerService;

	@Lazy
	@Autowired
	private FlightService flightService;

	@Lazy
	@Autowired
	private UserService userService;

	public List<BookingRecord> findAll() {
		return bookingDao.findAll();
	}

	
	@Transactional
	public BookingRecord bookFlight(BookingRecord record) {

		List<Passenger> passengersList = new ArrayList<>();

		record.getPassengers().forEach(passenger -> {
			if (!StringUtils.isEmpty(passenger.getFirstName()) && !StringUtils.isEmpty(passenger.getLastName())
					&& !StringUtils.isEmpty(passenger.getGender())
					&& !StringUtils.isEmpty(passenger.getMobileNumber())) {
				passengersList.add(passenger);
				// passenger.setBookingId(bookingRecordFromDB.getBookingId());
				// passengerService.save(passenger);
			}
		});

		BookingRecord bookingRecord = new BookingRecord(LocalDateTime.now(), record.getDestination(), record.getFare(),
				record.getFlightDate(), record.getFlightNumber(), record.getFlightTime(), record.getOrigin(), "Booked",
				passengersList);
		BookingRecord bookingRecordFromDB = bookingDao.save(bookingRecord);

		passengersList.forEach(passenger -> {
			passenger.setBookingId(bookingRecordFromDB.getBookingId());
			passenger.setCheckIn(new Checkin(null, null));
			passengerService.save(passenger);
		});

		

		Flight flight = flightService.findByFlightNumberAndFlightDateAndFlightTime(record.getFlightNumber(),
				record.getFlightDate(), record.getFlightTime());
		int count = flight.getInventory().getCount();
		flight.getInventory().setCount(count - record.getPassengers().size());
		flightService.saveFlight(flight);
		return bookingRecord;
	}

	public List<BookingRecord> findBookingRecordByUserId(String userName) {
		User user = userService.findByUserName(userName);
		System.out.println(user.getId());
		return bookingDao.getBookingRecordsByUserId(user.getId());
	}

	public BookingRecord getBookingById(int bookingId) {
		return bookingDao.findByBookingId(bookingId);
	}


}
