package com.quiz.lesson07.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// Spring data JPA

	// 엔티티 객체 save(엔티티) -> 1.insert(id가 null), 2.update(객체 or null)
	// Optional<엔티티객체> findById(id);
	// void delete(엔티티객체);

}
