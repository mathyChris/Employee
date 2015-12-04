package com.hybrid.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.exception.CityRegisterException;
import com.hybrid.model.City;


public class CityRegisterServiceTest {
	
	
	static Log log = LogFactory.getLog(CityRegisterServiceTest.class) ; 
	
	public static void main(String[] args){
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"spring/beans_service.xml" , 
				"spring/beans_dao.xml"); 
		
		CityRegisterService service = ctx.getBean(CityRegisterService.class); 
		
		City city = new City(); 
		city.setName("bootstrap");
		city.setDistrict("css framework");
		city.setCountryCode("web");
		city.setPopulation(12000000);
		
		
		try{
			
			int id = service.regist(city) ;
			log.info("city regist id = " + id); 
			
		
		}catch(CityRegisterException e){
			
			log.error("city register error..." , e);
			
		}
		
		
		ctx.close(); 
	}
	

}
