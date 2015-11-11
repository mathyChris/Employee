package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Member;

public interface CityMapper {
	
	
	List<City> selectAll() ; 
	List<City> selectByCountryCode(String countryCode); 
	
}
