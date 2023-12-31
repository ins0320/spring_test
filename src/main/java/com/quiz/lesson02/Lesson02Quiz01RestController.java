package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController // controller + responsebody
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO;
	
	// url: http://localhost/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store>quiz01() {
		
		//output: StoreBO로부터 받아옴 List<Store>
		return storeBO.getStoreBO();
	}
	
}
