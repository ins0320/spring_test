package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.mapper.BookingMapper;
import com.quiz.booking.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	};
}
