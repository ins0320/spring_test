package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp 파일로 반환하기에, @ResponseBody가 없어야 한다.
public class lesson01Quiz02Controller {

	@RequestMapping("/lesson01/quiz03") // Request url path
	public String quiz03() {
		// @ResponseBody가 아닌 단독으로 사용되는 @controller + return String 
		// ViewResolver에 의해 리턴된 String의 jsp 경로를 찾고 화면이 구성된다. -> HTML 응답(Response Body)
		return "lesson01/quiz03"; // Response return file 경로
	}
}
