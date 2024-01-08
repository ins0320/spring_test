package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {

	public void insertSellerMapper(
			@Param("nickname") String nickname,
			@Param("profileImageUrl") String profileImageUrl, 
			@Param("temperature") double temperature);
	
	// input: x, output: seller or null
	public Seller selectLatestSeller();
	
	// input: id, output: seller
	public Seller selectSellerById(int id);
}
