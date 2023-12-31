package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository  extends JpaRepository<RecruitEntity, Integer>{
	// Spring data JPA
	// Optional<엔티티객체> findById(id);
	
	// quiz02 - JPQL 
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type );
	public List<RecruitEntity> findByTypeOrSalary(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String reigon, int start, int end);
}
