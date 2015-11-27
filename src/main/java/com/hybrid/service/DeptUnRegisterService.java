package com.hybrid.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.dao.EmpDao;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;
import com.hybrid.model.Member;

public class DeptUnRegisterService {
	
	static Log log = LogFactory.getLog(DeptUnRegisterService.class) ; 
	
	
	DeptDao deptDao ;
	EmpDao empDao ;
	DataSource dataSource ; 

	
	public void setDeptDao(DeptDao deptDao){
		
		log.info("### DeptDao"); 
		
		this.deptDao = deptDao ; 
		
	}
	
	
	public void setEmpDao(EmpDao empDao){
		
		
		log.info("### EmpDao");
		
		this.empDao = empDao ; 
		
	}
	
	public void setDataSource(DataSource dataSource){
		
		log.info("### DataSource");
		
		this.dataSource = dataSource ;
		
	}
	
	
	
	@Transactional 
	public void unregist(Dept dept){
			
//		implementation of delete method 
		
		
//		부서를 지우기 전 직원들을 지우는 부분 --> 부서와 함께 직원을 없애는 logic 을 구현 
		List<Emp> emps = empDao.selectByDeptno(dept.getDeptno()); 
		
		for(Emp emp : emps){
			empDao.delete(emp); 
		}
		///////////////////////////////////// 위 code는 직원들의 삭제 
		
		deptDao.delete(dept); 
		
	}
	
	@Transactional
	public void unregist(int deptno){
		
		List<Dept> depts =  deptDao.selectGreaterThan(deptno); 
		
		for(Dept dept : depts) {
			
			unregist(dept); // 위에서 생성한 unregist(Dept dept) 을 가져와 구현 
			
		} 
		
//		deptDao.deleteGreaterThan(deptno) ; // 주어진  deptno 이상의 부서 번호에 해당하는 값을 다 지운다.
		
	}
	

}









