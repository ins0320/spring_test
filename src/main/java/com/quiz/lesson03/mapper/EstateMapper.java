package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.Estate;

@Repository
public interface EstateMapper {

	public Estate selectEstateById(@Param("id") int id);
	
}
