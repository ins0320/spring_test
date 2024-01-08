package com.quiz.lesson07.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
		return companyRepository.save(CompanyEntity.builder()
										.name(name)
										.business(business)
										.scale(scale)
										.headcount(headcount)
										.build()); // select한 완벽한 data를 return
	}
	
	// update
	public CompanyEntity updateCompanyByScaleHeadcount(int id, String scale, int headcount) {
		
		// select
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// update - save
		if(company != null) {
			company = company.toBuilder() // 기존 필드값 유지, scale, headcount만 변경
			.scale(scale)
			.headcount(headcount)
			.build(); // 반드시 다시 저장한다!!
			
			// update
			company = companyRepository.save(company);
		}
		return company; // company or null (update 실패시 null)
	}
	
	// delete
	public void deleteCompanyById(int id) {
		 // delete
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
