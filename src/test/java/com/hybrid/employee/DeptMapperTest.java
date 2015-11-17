package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptMapperTest {

	
	static Log log = LogFactory.getLog(DeptMapperTest.class); 
	
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml"); 
		
		DeptMapper deptMapper = ctx.getBean(DeptMapper.class) ;
		
//		List<Dept> list = deptMapper.selectAll() ;
		List<Dept> list = deptMapper.selectAllWithEmps();
		
		list.forEach(new Consumer<Dept>() {

			@Override
			public void accept(Dept d) {

//				log.info(" Deptno = " + d.getDeptno()); 
				
				log.info("\n");
				
				String msg = "deptno = " + d.getDeptno() + "\t dname = " + d.getDname() + 
						"\t loc = " + d.getLoc() ;
				
				log.info(msg); 
				
				List<Emp> emps = d.getEmps() ; 
				
					emps.forEach(new Consumer<Emp>() {

						@Override
						public void accept(Emp e) {

							String string = e.getEmpno() + "\t" + e.getEname() + "\t" + e.getJob()
											+ "\t" + e.getComm() + "\t" + e.getMgr() + "\t" + e.getSal()
											+ "\t" + e.getHiredate() 
											+ "\t" + e.getDept().getDeptno(); 
							
							log.info(string);
						}
						
					});
				
			}
		});
		
		
		
		Dept dept = deptMapper.selectByDeptno(20) ; 
		
		String msg = "deptno = " + dept.getDeptno() + "\t dname = " + dept.getDname() + 
				"\t loc = " + dept.getLoc() ;
		
		log.info("\n");
		
		log.info("DeptnoInfo : " + msg); 
		
		
		//////////////////////////////////////////////////////////////////
		
		Dept d = deptMapper.selectByDeptnoWithEmps(30) ;
		
		
				String msg2 = "" + d.getDeptno() + 
							"\t" + d.getDname() + 
							"\t" + d.getLoc() ; 

				log.info("\n");
				log.info(msg2); 
				
				List<Emp> emps = d.getEmps() ; 
				
				
				
				if(emps != null) {
					
					emps.forEach(new Consumer<Emp>() {
	
						@Override
						public void accept(Emp e) {
	
							String string = e.getEmpno() + "\t" + e.getEname() + "\t" + e.getJob()
											+ "\t" + e.getComm() + "\t" + e.getMgr() + "\t" + e.getSal()
											+ "\t" + e.getHiredate() 
	//										+ "\t" + e.getDeptno();
											+ "\t" + e.getDept().getDeptno(); 
							
							log.info(string);
						}
						
					});
			}
		////////////////////////////////////////////////////////////////////
		
	}

}



