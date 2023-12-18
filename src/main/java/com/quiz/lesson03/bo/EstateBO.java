package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Estate;
import com.quiz.lesson03.mapper.EstateMapper;

@Service
public class EstateBO {

	@Autowired
	private EstateMapper estatemapper;
	
	
	public Estate getEstateById(int id) {
		return estatemapper.selectEstateById(id);
	}
}
