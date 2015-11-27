package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Emp;

public interface EmpMapper {
	
	
	List<Emp> selectAll(); 
	List<Emp> selectAllWithDept();
	List<Emp> selectByDeptno(int deptno); 	// deptno(부서 코드) 로 해당 직원들을 검색하는 method 
	
	////////////////////////////////////// myself code 
//	List<Emp> selectByDeptno(int deptno); 
//	Emp selectByDeptnoWithDept(int deptno); 
	
	
	
	////////////////////////////////////// instructor code 
	Emp selectByEmpno();
	Emp selectByEmpnoWithDept();
	
		
	int insert(Emp emp); 

	int delete(Emp emp); 
	

	
}
