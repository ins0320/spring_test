package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
			//db insert
			sellerBO.addSeller(nickname, profileImageUrl, temperature);
			
			return "/lesson04/afterAddSeller";
	}
	@GetMapping("/seller-info-view")
	public String latestSeller(
			@RequestParam(value = "id", required = false) Integer id
			, Model model) {//  Model: view 화면에 데이터를 넘겨주는 객체

		Seller seller = null;
		
		// id를 치면 => getSellerById   id 안치면 => getLastSeller
		if( id == null) {
			 seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		// model에 담기
		model.addAttribute("title","판매자정보");
		model.addAttribute("result", seller );
		
		// 응답화면
		return "lesson04/sellerInfo";
	}
}
