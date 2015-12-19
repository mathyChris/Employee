package com.hybrid.service;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;
import com.hybrid.exception.CityRegisterException;
import com.hybrid.model.City;


public class CityUnRegisterService {
	
	
	CityDao cityDao  ;
	
	public void setCityDao(CityDao cityDao){
		
		this.cityDao = cityDao ; 
		
	}
	
	
	@Transactional //이 표시가 없으면 transaction이 되지 않는다. beans_oracle 에서 
	public int unregist(int id){
		
		cityDao.deleteById(id); 
		
		return id ;
		
	}
		

}
