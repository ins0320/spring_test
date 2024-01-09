package com.quiz.lesson07;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	// !!! 이번에만 BO 생략
	@Autowired
	private RecruitRepository recruitRepository;

	// id로 조회
	@GetMapping("1")
	
	public Optional<RecruitEntity> getrecuitById() {
		return recruitRepository.findById(8);
	}
	
	// Parameter 조건 조회
	@GetMapping("2")
	public List<RecruitEntity> getrecuitByCompanyId(){
		return recruitRepository.findByCompanyId(1);
	}
	
	// 복합 조건 조회: 웹 back-end 개발자 이고 정규직
	@GetMapping("3")
	public List<RecruitEntity> getrecuitByPositi(){
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직" );
	}
	
	// 복합 조건 조회: 정규직이거나 연봉이 9000 이상
	@GetMapping("4")
	public List<RecruitEntity> getrecuitByTypeOrSalary(){
		return recruitRepository.findByTypeOrSalary("정규직", 9000);
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
	
}
