package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO { // 가공을 하는 것은 BO

	@Autowired
	private BookingMapper bookingMapper;
	
	public void addBooking(String name,  Date date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	};
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	};
	
	// 예약 조회하기
	// 없으면 null, 있으면 객체 return
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber){
		// 없는경우: [], 있는경우: [...]
		List<Booking> bookingList =  bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		
//		if (bookingList.isEmpty()) { // 비어있음
//			return null;
//		}
//		bookingList.get(bookingList.size() - 1); // 마지막(최신) 리스트 값 가져옴
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
	
	public int deleteBooking(int id) {
		return bookingMapper.deleteBooking(id);
	};
	
	
}
