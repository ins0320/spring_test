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
	
	// insert한 행의 개수
	// input: Estate output: 리턴한 행의 개수(int)
	public int addEstate(Estate estate) {
		return estateMapper.insertEstate(estate);
	}
	
	// input: addEstateByfiled("샹떼빌리버 오피스텔 814호", 45, "월세", 1000000, 120);
	// output: return 한 행의 개수
	public int addEstateAsfiled(
			int realtorId
			,String address 
			, int area
			, String type
			, int price
			,Integer rentPrice
			) {
		return estateMapper.inesrtEstateAsfiled(realtorId,address, area, type, price, rentPrice);
	}
	
	//updateEstateBO
	//input: estate output:return 한 행의 개수
	public int updateEstateById(int id, String type, int price) {
		return estateMapper.updateEstateById(id, type, price);
	}
}
