package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.mapper.BookingMapper;
import com.quiz.booking.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public void addBooking(String name,  Date date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	};
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	};
	
	// 예약 조회하기
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber){
		return bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
	}
	
	public int deleteBooking(int id) {
		return bookingMapper.deleteBooking(id);
	};
	
	
}
