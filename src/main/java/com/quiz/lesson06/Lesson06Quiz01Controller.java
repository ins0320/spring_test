package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

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
	@RequestMapping("/add-bookmark")
	@ResponseBody
	public String addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		bookmarkBO.addBookmark(name, url);
		return "성공";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmark(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		model.addAttribute("bookmarkList",bookmarkList);
		return "/lesson06/afterAddBookmark";
	}
}
