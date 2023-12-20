package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;

@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private EstateBO estateBO;
	
	@RequestMapping("/lesson03/quiz03")
	public String quiz03(
			@RequestParam("id") int id) {
		int rowCount = estateBO.deleteEstateById(id);
		return "삭제 성공" +  rowCount;
	}
}
