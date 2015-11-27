package com.hybrid.dao;

import java.util.List;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public class CityDao {
	
	
	CityMapper cityMapper; 
	
	
	public void setCityMapper(CityMapper cityMapper){
		
		this.cityMapper = cityMapper ; 
		
	}
	
	
	public int selectCount() {
		
		
		return cityMapper.selectCount()  ;
	} // totalItem의 개념 
	
	
	public List<City> selectAll() {
		
		return cityMapper.selectAll(); 
	} 
	
	
	public List<City> selectPage(Pagination paging){
		
		return cityMapper.selectPage(paging)  ;
	} // 
	
	
	public List<City> selectByCountryCode(String countryCode){
		
		
		return cityMapper.selectByCountryCode(countryCode) ;
	}
	
	public int insert(City city) {
		
		return cityMapper.insert(city) ; 
	}
	
	public int deleteAll() {
		
		return cityMapper.deleteAll() ; 
	}
	
	
}
