package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	// input: nickname, profileImageUrl, temperature   output: X
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertSellerMapper(nickname, profileImageUrl, temperature);
	}
	
	// input: x, output: seller or null
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// input: id, output: seller
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
	
}
