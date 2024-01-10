package com.quiz.lesson07;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02/")
@RestController
public class Lesson07Quiz02RestController {
	// !!! 이번에만 BO 생략
	@Autowired
	private RecruitRepository recruitRepository;

	// id로 조회
	@GetMapping("1")
	
	public RecruitEntity getrecuitById() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	// Parameter 조건 조회
	@GetMapping("2")
	public List<RecruitEntity> getrecuitByCompanyId(
			@RequestParam("companyId") int companyId){
		return recruitRepository.findByCompanyId(companyId);
	}
	
	// 복합 조건 조회: 웹 back-end 개발자 이고 정규직
	@GetMapping("3")
	public List<RecruitEntity> getrecuitByPositi(){
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직" );
	}
	
	// 복합 조건 조회: 정규직이거나 연봉이 9000 이상
	@GetMapping("4")
	public List<RecruitEntity> getrecuitByTypeOrSalary(){
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	// 정렬 제한 조건: 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
	@GetMapping("5")
	public List<RecruitEntity> getrecuitByType(){
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
	}
	
	// 범위 조회: 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고
	@GetMapping("6")
	public List<RecruitEntity> getrecuitByRegion(){
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000,8500);
	}
	
	// Native query(/lesson07/quiz02/7)
	@GetMapping("7")
	public List<RecruitEntity> quiz02_7(){
		// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회
		return recruitRepository.findDeadlineSalaryType("2026-04-10", 8100, "정규직"); // after: 초과
	}
	
}
