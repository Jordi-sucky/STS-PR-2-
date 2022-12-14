package com.sucky.pr.p05total.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sucky.pr.p05total.model.Weather;

@Repository("WeatherDAO")
public interface WeatherDAO {
	
	public List<Weather> selectWeather();
	
	public int insertWeather(
			@Param("date")Date date
			, @Param("weather")String weather
			, @Param("temperatures")double temperatures
			, @Param("precipitation")double precipitation
			, @Param("microDust")String microDust
			, @Param("windSpeed")double windSpeed
			);
}
