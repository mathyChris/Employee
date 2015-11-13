package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;

public interface CityMapper {
	
	
	List<City> selectAll() ; 
	List<City> selectByCountryCode(String countryCode); 
	
	int insert(City city) ;
	
	
}
