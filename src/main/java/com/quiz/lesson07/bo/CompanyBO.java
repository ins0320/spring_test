package com.quiz.lesson07.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// JPA로 insert
	public CompanyEntity addCompany(
			String name, String business, 
			String scale, int headcount ) {
		
		CompanyEntity company = CompanyEntity.builder()// builder 세팅 열기
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.createdAt(ZonedDateTime.now()) // @UpdateTimeStamp가 있으면 생략 가능
				.build();// builder 닫기
	
		return companyRepository.save(company); // select한 완벽한 data를 return
	}
	
}
