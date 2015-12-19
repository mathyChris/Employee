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
	
	
	//
	public City selectById(int id){
		
		
		return cityMapper.selectById(id) ;
		
	}
	
	
	public List<City> selectByCountryCode(String countryCode){
		
		
		return cityMapper.selectByCountryCode(countryCode) ;
		
	}
	
	
	public int insert(City city) {
		
		int rtn = cityMapper.insert(city) ; 
		
		return city.getId() ; 
		
//		return cityMapper.insert(city); // insert 의 원래 return 값 ==> 이를 위와 같이 변경 
	}
	
	//
	public int update(City city) {
		
		return cityMapper.update(city) ; 
	}
	
	//
	public int deleteById(int id) {
		
		return cityMapper.deleteById(id) ; 
	}
	
	public int deleteAll() {
		
		return cityMapper.deleteAll() ; 
	}
	
	
}



