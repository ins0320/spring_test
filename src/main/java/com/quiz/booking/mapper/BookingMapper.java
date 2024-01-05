package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper { // data를 가져오는 것

	public void insertBooking(
			@Param("name")String name
			, @Param("date") Date date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber")String phoneNumber);
	
	public List<Booking> selectBookingList();
	
	// 예약 조회하기
	// input: 이름, 전화번호  output:List<Booking>
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name 
			,@Param("phoneNumber") String phoneNumber);
	
	// delete booking
	public int deleteBooking(int id);
}
