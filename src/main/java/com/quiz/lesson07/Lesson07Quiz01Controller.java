package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;


@RequestMapping("/lesson07")
@RestController
public class Lesson07Quiz01Controller {

	@Autowired
	private CompanyBO companyBO;
	
	// c: create
	@GetMapping("/quiz01/1")
	public CompanyEntity create() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		// 방금 인서트된 pk id로 바로 얻어낼 수 있다.
				return companyBO.addStudent(name, phoneNumber, email, dreamjob);
	}
}
