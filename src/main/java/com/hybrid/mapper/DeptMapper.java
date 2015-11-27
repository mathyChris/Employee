package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;

public interface DeptMapper {
	
	
//	아래 4개의 메서드는 4개의 select tag 로 만든다. 
	List<Dept> selectAll() ; 
	List<Dept> selectAllWithEmps() ;
	
	Dept selectByDeptno(int deptno) ;
	Dept selectByDeptnoWithEmps(int deptno) ; 
	
	
	int insert(Dept dept); 
	
	
	// delete  부분을 새롭게 생성 
	int delete(Dept dept);
	int deleteGreaterThan(int deptno); 
	
	List<Dept> selectGreaterThan(int deptno); 
	
}
