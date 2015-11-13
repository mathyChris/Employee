package com.hybird.mapper;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.mapper.CountryMapper;
import com.hybrid.model.Country;

public class CountryMapperTest {

	static Log log = LogFactory.getLog(CountryMapperTest.class); 
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml"); 
			
		CountryMapper conMapper = ctx.getBean(CountryMapper.class) ;
		
		List<Country> list = conMapper.selectAll(); 
		
		list.forEach(new Consumer<Country>() {

			@Override
			public void accept(Country c) {

				log.info(c.getCode() + "\t" + c.getCapital() + "\t" + c.getGovernmentForm()); 
				
			}
		});

		
		
		
	}

}
