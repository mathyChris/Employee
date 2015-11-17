package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class EmpMapperTest {

	
	static Log log = LogFactory.getLog(EmpMapperTest.class); 
	
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml"); 
		
		EmpMapper empMapper = ctx.getBean(EmpMapper.class) ;
		
//		List<Emp> list = empMapper.selectAll() ;
		List<Emp> list = empMapper.selectAllWithDept() ;

		
		list.forEach(new Consumer<Emp>() {

			@Override
			public void accept(Emp e) {
				
				log.info("\n");
				
				String msg =  e.getEmpno() + 
					   "\t" + e.getEname() + 
					   "\t" + e.getJob() + 
					   "\t" + e.getComm() + 
					   "\t" + e.getMgr() + 
					   "\t" + e.getSal() +
					   "\t" + e.getHiredate() ; 
		
				
				log.info(msg); 
				
				Dept d = e.getDept() ;
				
							String string = d.getDeptno() + 
									  "\t" + d.getDname() +  
									  "\t" + d.getLoc() ;
									  
							log.info(string);
				
			}
		});
		
		
		
//		Dept dept = deptMapper.selectByDeptno(20) ; 
//		
//		String msg = "deptno = " + dept.getDeptno() + "\t dname = " + dept.getDname() + 
//				"\t loc = " + dept.getLoc() ;
//		
//		log.info("\n");
//		
//		log.info("DeptnoInfo : " + msg); 
		
		
		List<Emp> list2 = empMapper.selectByDeptno(20); 
		
		
		list2.forEach(new Consumer<Emp>() {

			@Override
			public void accept(Emp emp) {

				String string = emp.getEmpno() + 
						 "\t" + emp.getEname() + 
						 "\t" + emp.getJob() + 
						 "\t" + emp.getMgr() + 
						 "\t" + emp.getSal() + 
						 "\t" + emp.getHiredate() + 
						 "\t" + emp.getComm() +
						 "\t" + emp.getDeptno() ;
				
				log.info("\n");
				
				log.info("Emp Info. = " + string); 
				
				
				
			}
		});
		
		

		
		//////////////////////////////////////////////////////////////////
		
//		Dept d = deptMapper.selectByDeptnoWithEmps(30) ;
//		
//		
//				String msg2 = "" + d.getDeptno() + 
//							"\t" + d.getDname() + 
//							"\t" + d.getLoc() ; 
//
//				log.info("\n");
//				log.info(msg2); 
//				
//				List<Emp> emps = d.getEmps() ; 
//				
//				
//				
//				if(emps != null) {
//					
//					emps.forEach(new Consumer<Emp>() {
//	
//						@Override
//						public void accept(Emp e) {
//	
//							String string = e.getEmpno() + "\t" + e.getEname() + "\t" + e.getJob()
//											+ "\t" + e.getComm() + "\t" + e.getMgr() + "\t" + e.getSal()
//											+ "\t" + e.getHiredate() 
//	//										+ "\t" + e.getDeptno();
//											+ "\t" + e.getDept().getDeptno(); 
//							
//							log.info(string);
//						}
//						
//					});
//			}
		////////////////////////////////////////////////////////////////////
		
	}

}



