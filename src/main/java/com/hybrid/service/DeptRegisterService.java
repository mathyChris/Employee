package com.hybrid.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.dao.EmpDao;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;
import com.hybrid.model.Member;

public class DeptRegisterService {
	
	
	DeptDao deptDao  ;
	EmpDao empDao ; // 새로 추가 
	
	public void setDeptDao(DeptDao deptDao){
		
		this.deptDao = deptDao ; 
		
	}
	
	// 새로 추가, 
	public void setEmpDao(EmpDao empDao){ 
		
		this.empDao = empDao ;
		
	}
	
	
/////////////////////////////////////////////////////////////////	
	DataSource dataSource ; // sql에 있는 것으로 DataSource 생성 
	
	public void setDataSource(DataSource dataSource){
		
		this.dataSource = dataSource ;
		
	}
/////////////////////////////////////////////////////////////////
	
	
	public void regist(Dept dept){
		
//		throw new RuntimeException(); // RuntimeException 이 발생하도록 강제적으로 coding for test 	
	
// 		In order to proceed the below, need to make the same code lines to the each.
//		So we have to get this part move into the AOP code. 
		DataSourceTransactionManager transactionManager = null ; 
		transactionManager = new DataSourceTransactionManager() ; 
		transactionManager.setDataSource(dataSource); 
		
		TransactionDefinition td  = new DefaultTransactionDefinition(); // default setting is initiative 
		TransactionStatus ts = transactionManager.getTransaction(td) ;
	
		
		try{
			
			deptDao.insert(dept) ; // 부서 정보를 입력하는 기능 
			
			// 아래는 부서에 포함된 직원들까지 집어넣는 logic 
			List<Emp> emps = dept.getEmps() ;
			
			if(emps!= null) 
			for(Emp e : emps) {
				
				empDao.insert(e); 
			}
  			////////////////////////////////////////
			
			transactionManager.commit(ts); // 성공 시 commit 
		
		}catch(RuntimeException e){
			
			System.out.print(e.getMessage()); 
			
			transactionManager.rollback(ts); // Failure occurs then rollback 
			
		}
		
		
		
		
		
		
	}
	

}
