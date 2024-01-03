package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.weather_history.bo.WeatherhistoryBO;
import com.quiz.weather_history.domain.Weather;


@RequestMapping("/weather-history")
@Controller
public class weather_historyController {
	
	@Autowired
	private WeatherhistoryBO weatherhistoryBO;
	
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {		
		return "weather_history/addWeather";
	}
	
	// 날씨 추가
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, 
			@RequestParam("weather") String weather, 
			@RequestParam("temperatures") double temperatures, 
			@RequestParam("precipitation") double precipitation, 
			@RequestParam("microDust") String microDust, 
			@RequestParam("windSpeed") double windSpeed) {	
		
		weatherhistoryBO.addWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/weather_history/weather-list-view";
	}
	
	// 날씨 리스트
		@GetMapping("/weather-list-view")
		public String weatherListView(Model model) {
			
			// select
			List<Weather> weatherhistory = weatherhistoryBO.getWeatherhistory();
			model.addAttribute("weatherhistoryList",weatherhistory );
			
			
			return "weather_history/weatherList";
		}
		
}
