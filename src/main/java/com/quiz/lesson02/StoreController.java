package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.domain.NewReview;

@RequestMapping("/store")
@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	@GetMapping("/store-view")
	public String storeView(Model model) {
		
		List<Store> store = storeBO.getStoreBO();
		model.addAttribute("storeList",store);
		return "/store/storeList";
	}
	
	@GetMapping("/store-review")
	public String storeReview(
			@RequestParam("storeId") int storeId
			, Model model) {
		
			List<NewReview> review = storeBO.getReviewBO(storeId);
			model.addAttribute("reviewList",review);
			
			return "/store/newStoreList";
		}

}
