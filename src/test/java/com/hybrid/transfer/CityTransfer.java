package com.hybrid.transfer;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public class CityTransfer {
	
	static Log log = LogFactory.getLog(CityTransfer.class) ;

	public static void main(String[] args) {
		
		log.info("xxxxx");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml", 
																			"spring/beans_oracle.xml"); 
		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper"); 
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper"); 
		
		
//		oracleCityMapper.deleteAll() ; 
	
		int deleteCount = oracleCityMapper.deleteAll();
		log.info("Oracle City Delete Count = " + deleteCount);
		
 		
		List<City> list = mysqlCityMapper.selectAll(); 
		
		
/*		
// 		mysql로 새로 생성한 selectPage(paging)으로 test 
  
		Pagination paging = new Pagination(); 
		paging.setTotalItem(4079);
		paging.setPageNo(2);
		
		List<City> list = mysqlCityMapper.selectPage(paging); 
*/
		
		
		log.info(list.size()) ;
		
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City c) {
				
//				int cityCount  = oracleCityMapper.insert(c) ;
//				log.info(cityCount); 
				
				System.out.print(".");
				System.out.flush();
				
				
				// switching code "null" to " "
				if(c.getDistrict().equals("")){
					
					c.setDistrict(" "); 
					
				} // There are some 'null' data of district in "mysql" so the process to transfer data to oracle, get a null problem happen 
				
				int rtn = oracleCityMapper.insert(c);
				log.info("rtn = " + rtn);
			}
		});
		
		// 오전 		
		int cityCount = oracleCityMapper.selectCount();
		log.info("Oracle City Total Count = " + cityCount);
		
		ctx.close(); 
		
	}

}




