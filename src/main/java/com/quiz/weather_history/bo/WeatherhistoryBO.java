package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.Weather;
import com.quiz.weather_history.mapper.WeatherhistoryMapper;

@Service
public class WeatherhistoryBO {

	@Autowired
	private WeatherhistoryMapper weatherhistoryMapper;
	
	public void addWeatherHistory(
			Date date, 
			String weather, 
			double temperatures, 
			double precipitation, 
			String microDust, 
			double windSpeed) {
		
		weatherhistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
	}
	
	public List<Weather> getWeatherhistory(){
		return weatherhistoryMapper.selectWeatherhistory();
	}
}
