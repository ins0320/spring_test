package com.quiz.lesson01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")

@Controller
public class lesson01Quiz01Controller {

	@ResponseBody
	@RequestMapping("/01")
	public String quiz01() {
		return "<h3>테스트 프로젝트 완성 </h3> "
				+ "<br> "
				+ "<h5>해당 프로젝르틑 통해서 문제 풀이를 진행합니다.</h5>";
	}
	
	@ResponseBody
	@RequestMapping("/02")
	public Map<String,Object> quiz02() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어",85);
		
		return map;
	}
	

}
