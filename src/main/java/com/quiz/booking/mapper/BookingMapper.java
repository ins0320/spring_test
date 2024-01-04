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
	
	// 예약 조회하기
	public Booking selectBookingByNamePhoneNumber(String name, String phoneNumber);
	
	// delete booking
	public int deleteBooking(int id);
}
