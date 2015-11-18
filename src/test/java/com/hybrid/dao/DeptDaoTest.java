package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;

public class DeptDaoTest {
	
	
	static Log log = LogFactory.getLog(DeptDaoTest.class) ; 
	
	public static void main(String[] args){
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml"); 
	
		DeptDao dao = ctx.getBean(DeptDao.class) ;
		
		List<Dept> list = dao.selectAll() ;
		
		log.info("dept size = " + list.size());
		
		list = dao.selectAllWithEmps() ;
		
		log.info("dept size = " + list.size()); 
	
//		두개의 method 가 끝날 때 끝날 때 log를 삽입하고자 한다. 방법은? 
		
		dao.selectByDeptno(10) ;
		
		dao.selectByDeptnoWithEmps(30) ;
		
	}
	

}
