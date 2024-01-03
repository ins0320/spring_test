package com.quiz.booking.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.booking.model.Booking;

@Repository
public interface BookingMapper {

	public List<Booking> selectBookingList();
}
