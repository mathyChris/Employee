package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public interface CityMapper {
	
	int selectCount(); // totalItem의 개념 
	List<City> selectAll() ; 
	List<City> selectPage(Pagination paging); // 
	List<City> selectByCountryCode(String countryCode); 
	
	int insert(City city) ;
	
	int deleteAll(); 
	
	
}
