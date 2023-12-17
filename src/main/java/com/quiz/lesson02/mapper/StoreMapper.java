package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Repository
public interface StoreMapper {
	
	// input: (BO로 부터 받아오는 것)x
	// output: service에게 List<Store> 반환
	public List<Store> selectStoreList();
}
