package com.hybrid.service;

import java.util.List;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;
import com.hybrid.model.CityList;

public class CityListService {
	
	CityDao cityDao ; 

	
	public void setCityDao(CityDao ciyDao){
		
		this.cityDao = ciyDao ; 
		
	}
	
	
	public CityList getList() {
		
		List<City> cities = cityDao.selectAll() ; 
		
		CityList rtn = new CityList(); 
		rtn.setCities(cities);
		
		return rtn ;
	}

}
