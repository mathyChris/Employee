package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Emp;

public interface EmpMapper {
	
	
	List<Emp> selectAll(); 
	List<Emp> selectAllWithDept();
	
	
	////////////////////////////////////// myself code 
//	List<Emp> selectByDeptno(int deptno); 
//	Emp selectByDeptnoWithDept(int deptno); 
	
	
	
	////////////////////////////////////// instructor code 
	Emp selectByEmpno();
	Emp selectByEmpnoWithDept();
	
		
	int insert(Emp emp); 

}
