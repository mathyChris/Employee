package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.City;
import com.hybrid.model.Dept;
import com.hybrid.util.Pagination;

public class CityDaoTest {
	
	
	static Log log = LogFactory.getLog(CityDaoTest.class) ; 
	
	public static void main(String[] args){
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml"); 
	
		CityDao dao = ctx.getBean(CityDao.class) ;
		
		List<City> list = dao.selectAll() ;
		
		log.info("dept size = " + list.size());
		
		Pagination paging = new Pagination() ; 
		paging.setPageNo(5);
		paging.setTotalItem(dao.selectCount()); 

		List<City> page = dao.selectPage(paging);
		log.info("Page size = " + page.size()) ; 
		
		
		
//		list = dao.selectAll() ;
//		
//		log.info("dept size = " + list.size()); 
	
//		두개의 method 가 끝날 때 끝날 때 log를 삽입하고자 한다. 방법은? 
		
//		dao.selectByDeptno(10) ;
//		
//		dao.selectByDeptnoWithEmps(30) ;
		
	}
	

}
