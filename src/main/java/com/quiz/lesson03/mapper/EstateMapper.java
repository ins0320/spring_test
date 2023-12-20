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
			// myBatis 문법 상 파라미터는 한 개만 xml로 보낼 수  있다.
			// 파라미터들을 하나의 맵에 담아서 보낸다.
			// 맵으로 만들어주는 어노테이션 @Param
			@Param("area") int area11 // xml에서 사용하는 별칭: @param("별칭")
			,@Param("price") int price11);
	
	public int insertEstate(Estate estate);
	
	public int inesrtEstateAsfiled(
			@Param("realtorId") int realtorId
			,@Param("address") String address
			, @Param("area")  int area
			, @Param("type")  String type
			, @Param("price") int price
			, @Param("rentPrice") Integer rentPrice);
	
	public int updateEstateById(
				@Param("id") int id
				, @Param("type") String type
				, @Param("price") int price);
	
}
