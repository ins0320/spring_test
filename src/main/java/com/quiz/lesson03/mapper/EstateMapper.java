package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.Estate;

@Repository
public interface EstateMapper {

	public Estate selectEstateById(@Param("id") int id);
	
	public List<Estate> selectEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<Estate> selectEstateByAareaPrice(
			@Param("area") int area
			,@Param("price") int price
			);
	
}
