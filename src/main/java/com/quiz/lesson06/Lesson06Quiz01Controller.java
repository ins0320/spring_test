package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.bo.BookmarkBO;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "/lesson06/addBookmark";
	}
	//ajax:String 리턴
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		bookmarkBO.addBookmark(name, url);
		return "성공";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmark() {
		return "/lesson06/afterAddBookmark";
	}
}
