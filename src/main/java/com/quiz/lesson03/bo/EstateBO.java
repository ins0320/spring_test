package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Estate;
import com.quiz.lesson03.mapper.EstateMapper;

@Service
public class EstateBO {

	@Autowired
	private EstateMapper estateMapper;
	
	// input: id  output: Estate(있거나 또는 null)
	public Estate getEstateById(int id) {
		return estateMapper.selectEstateById(id);
	}
	
	public List<Estate> getEstateByRentPrice(int rentPrice){
		return estateMapper.selectEstateByRentPrice(rentPrice);
	}
	
	public List<Estate> getEstateByAreaPrice(int area, int price){
		return estateMapper.selectEstateByAareaPrice(area, price);
	}
}
