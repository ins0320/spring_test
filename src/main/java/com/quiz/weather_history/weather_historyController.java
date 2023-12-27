package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.weather_history.bo.WeatherhistoryBO;
import com.quiz.weather_history.domain.Weather;


@RequestMapping("/weather-history")
@Controller
public class weather_historyController {
	
	@Autowired
	private WeatherhistoryBO weatherhistoryBO;
	
	// 날씨 리스트
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// select
		List<Weather> weatherhistory = weatherhistoryBO.getWeatherhistory();
		model.addAttribute("weatherhistoryList",weatherhistory );
		
		
		return "weather_history/weatherList";
	}
	
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {		
		return "weather_history/addWeather";
	}
	
	// 날씨 후가
	@PostMapping("/add-weather")
	public String addWeather() {		
		return "weather_history/weatherList";
	}
}
