package com.hybrid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptRegisterServiceTest {
	
	
	static Log log = LogFactory.getLog(DeptRegisterServiceTest.class) ; 
	
	public static void main(String[] args){
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml" , "spring/DeptModel_oracle.xml"); 
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml"); 
		
		
		DeptRegisterService service = ctx.getBean(DeptRegisterService.class); 
		DeptUnRegisterService uservice = ctx.getBean(DeptUnRegisterService.class); 
		
//		Dept dept = new Dept(); 
//		dept.setDeptno(71);
//		dept.setDname("ExpTest");
//		dept.setLoc("Seoul");
//		
//		/////////////////////////////// 추가된 부분 
//		Emp emp = new Emp() ; 
//		emp.setEmpno(10);
//		emp.setEname("Lora");
//		emp.setJob("tester");
//		emp.setMgr(2000);
//		emp.setHiredate(new Date());
//		emp.setSal(1000f);
//		emp.setComm(200.0f);
//		emp.setDept(dept);
		
//		List<Emp> emps = new ArrayList<Emp>(); 
//		emps.add(emp); 
//		
//		dept.setEmps(emps);
		
		
		
		// bean 으로 모델 객체를 설정하였기 때문에 아래 코드 가능 -> beans_oracle.xml
		Dept dept1 = ctx.getBean(Dept.class); 
		

		//////////////////////////////////
		
		uservice.unregist(dept1);
		
		service.regist(dept1); 
		
	}
	

}
