package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Lesson04Quiz01Controller {
	
	@GetMapping
	public String addSellerView() {
		return "lesson04/addSeller";
	}
}
