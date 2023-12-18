package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.domain.Estate;

@RestController
public class lesson03Quiz01RestController {

	@Autowired
	private EstateBO estateBO;
	
	@RequestMapping("/lesson03/quiz01/01")
	public Estate quiz01Controller(
			@RequestParam(value="id") int id) {
		return estateBO.getEstateById(id);
	}
}
