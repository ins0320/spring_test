package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.domain.NewReview;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {

	@Autowired
	private StoreMapper storeMapper;
	
	public List<Store> getStoreBO(){
		// input: (컨트롤러로부터 받아오는 것) x
		// output:  repository로부터 받은 것을 ( List<Store> ) controller로 보냄
		return storeMapper.selectStoreList();
	}
	
	public List<NewReview> getReviewBO(int storeId){
		
		return storeMapper.selectReviewById(storeId);
	}
}
