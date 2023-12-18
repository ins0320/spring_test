package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.domain.Estate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private EstateBO estateBO;
	
	@RequestMapping("/01")
	public Estate test01_01(
			@RequestParam("id") int id) {
		return estateBO.getEstateById(id);
	}
	
	@RequestMapping("/02")
	public List<Estate>  test01_02(
			@RequestParam(value="rentPrice") int rentPrice) {
		
		return estateBO.getEstateByRentPrice(rentPrice);
	}
	
	@RequestMapping("/03")
	public List<Estate> test01_03(
			@RequestParam("area") int area
			,@RequestParam("price") int price
			){
		return estateBO.getEstateByAreaPrice(area, price);
	}
}
