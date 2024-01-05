package com.quiz.booking;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller // 요청, 응답을 정의함
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	// localhost:8080/booking/booking-list-view

	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}


	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// 예약하기
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam(value="phoneNumber", required=false)String phoneNumber){
		
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		return result;
		
	};
	
	// 예약 삭제하기
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(@RequestParam("id") int id) {
		
		// delete db
		int rowCount = bookingBO.deleteBooking(id);
		Map<String, Object> result = new HashMap<>();

		if (rowCount > 0) {
			// 성공
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제하는데 실패했습니다.");
		}
		return result;
	}
	
	// 예약 조회하기 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "/booking/checkBooking";
	}
	
	// 예약 조회하기
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber
			, Model model){
		
		// {"code":200, "result":booking 객체}
		// {"code":200, "result":{"name":신보람,...}}
		Map<String, Object> result = new HashMap<>();
		
		Booking booking =  bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		if(booking == null) {
			// {"code":500, "error_message":"예약내역이 존재하지 않습니다."}
			result.put("code", 500);
			result.put("error_message","예약내역이 존재하지 않습니다." );
		} else {
			result.put("code", 200);
			result.put("result",booking );
		}
		 
		 return result;
	}
	

}
