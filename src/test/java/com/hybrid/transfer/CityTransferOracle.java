package com.hybrid.transfer;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public class CityTransferOracle {
	
	static Log log = LogFactory.getLog(CityTransferOracle.class) ;

	public static void main(String[] args) {
		

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml", 
																			"spring/beans_oracle.xml"); 
		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper"); 
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper"); 
		
		
		int deleteCount = oracleCityMapper.deleteAll(); 
 		log.info("delete count =  "+ deleteCount); 
		
		
		List<City> list = oracleCityMapper.selectAll(); 
		
		
		
		
		log.info(list.size()) ;
		
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City c) {
				
				
				System.out.println(".");
				System.out.flush();
				
				if(c.getDistrict() == null)
					c.setDistrict("");
				
				int rtn = mysqlCityMapper.insert(c) ;
				log.info("rtn = " + rtn); 
				
			}
		});
		
		// 오전 
//		int cityCount = oracleCityMapper.insert(c); 
//		log.info(cityCount); 
		
		int cityCount = mysqlCityMapper.selectCount(); 
		log.info("Mysql city total count = " + cityCount);
		
		ctx.close(); 
		
	}

}




