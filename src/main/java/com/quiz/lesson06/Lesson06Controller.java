package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;

	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "/lesson06/addBookmark";
	}

	// ajax:String 리턴
	// 입력수행 - AJAX 통신 요청 => 응답값 JSON String
	@PostMapping("/add-bookmark")
	@ResponseBody
	public Map<String, Object> addBookmark(@RequestParam("name") String name, @RequestParam("url") String url) {
		bookmarkBO.addBookmark(name, url);
		// "{"code"L200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // map => JSON String
	}

	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmark(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		model.addAttribute("bookmarkList", bookmarkList);
		return "/lesson06/afterAddBookmark";
	}
	
	// url 중복확인 - AJAX 요청
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		
		// db select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result; // map => JSON string
	}
	
	// 즐겨찾기 삭제 - AJAX요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id){
		
		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		
		if(rowCount > 0) {			
			result.put("code", 200); // 성공
			result.put("result", "성공");
		} else {
			result.put("code", 500); // 성공
			result.put("error_message", "삭제하는데 실패했습니다.");
		}		
		return result;
	}
	
}
