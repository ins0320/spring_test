package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.model.Booking;

@Repository
public interface BookingMapper {

	public void insertBooking(
			@Param("name")String name
			, @Param("date") Date date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber")String phoneNumber);
	
	public List<Booking> selectBookingList();
	
	// delete booking
	public int deleteBooking(int id);
}
