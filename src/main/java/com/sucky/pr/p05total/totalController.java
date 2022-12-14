package com.sucky.pr.p05total;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sucky.pr.p05total.bo.WeatherBO;
import com.sucky.pr.p05total.model.Weather;

@Controller
public class totalController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/p05/totalWeather")
	public String total1(Model model) {
		
		List<Weather> weathers = new ArrayList<>();
		
		weathers = weatherBO.getWeather();
		
		model.addAttribute("weathers", weathers);
		
		return "/p05/total1";
	}
	
	
	@PostMapping("/p05/insertWeather")
	public String insert_weather(
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam("date") Date date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed		
			) {
		
		int count = weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/p05/totalWeather";
	}
	
	@GetMapping("p05/insertView")
	public String insertView() {
		return "/p05/total2";
	}
}
