package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.domain.Estate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {

	@Autowired
	private EstateBO estateBO;
	
	@RequestMapping("/01")
	public String quiz02_01() {
		Estate estate = new Estate(); // java bean
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int resultCount = estateBO.addEstate(estate);
		return "입력성공 : " + resultCount;
	}
	
	@RequestMapping("/02")
	public String quiz02_02(@RequestParam("realtor_id") int realtorId) {
		int rowCount =  estateBO.addEstateAsfiled(realtorId,"샹떼빌리버 오피스텔 814호", 45, "월세", 1000000, 120);
		return "입력 성공 : " + rowCount;
	}
}
