package com.hybird.mapper;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class CityMapperTest {

	static Log log = LogFactory.getLog(CityMapperTest.class); 
	
	public static void main(String[] args){
		
		GenericXmlApplicationContext ctx = null ; 
		
		ctx = new GenericXmlApplicationContext("spring/beans_dao.xml"); 
		
		CityMapper cityMapper = ctx.getBean(CityMapper.class) ;
		
//		List<City> list = cityMapper.selectAll(); 
		
		List<City> list = cityMapper.selectByCountryCode("KOR") ;
		
		
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City c) {
				
				log.info(c.getCountryCode() + "\t" +c.getName()); 
				
			}
			
		});
		
		
//		for(City c : list){
//			
//			log.info(c.getCountryCode()); 
//			
//		}
		
		ctx.close(); 
		
	}
	
	
}
