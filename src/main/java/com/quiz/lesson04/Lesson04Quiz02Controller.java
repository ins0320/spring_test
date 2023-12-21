package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/addRealtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor
			, Model model) {
		
		realtorBO.addRealtor(realtor);
		
		// 추가한 데이터의 id를 가져옴
		Realtor result = realtorBO.getRealtorById(realtor.getId());
		
		model.addAttribute("title", "공인중개사 정보");
		model.addAttribute("result",result);
		
		return "lesson04/realtorInfo";
	}
}
