package com.hybrid.dao;

import java.util.List;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.City;
import com.hybrid.model.Emp;

public class EmpDao {
	
	EmpMapper empMapper ; // beans_oracle.xml 에 가서 등록 
	
	public void setEmpMapper(EmpMapper empMapper){
		
		this.empMapper = empMapper ;
	} //setter 설정 후 beans_oracle.xml 에 가서 등록해야 한다. 
	
	
	
	public List<Emp> selectAll(){
		
		return empMapper.selectAll() ;
		
	} 
	public List<Emp> selectAllWithDept(){
	
		
		return empMapper.selectAllWithDept(); 
	}
	
	
	////////////////////////////////////////////// instructor
	public Emp selectByEmpno(){
		
		return empMapper.selectByEmpno(); 
		
	}
	////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////instructor
	public Emp selectByEmpnoWithDept(){
		
		return empMapper.selectByEmpnoWithDept(); 
	}
	//////////////////////////////////////////////////
	
	
	public int insert(Emp emp){
		
		return empMapper.insert(emp) ;
	
	}
	
	
//	public List<Emp> selectByDeptno(int deptno){
//	
//	
//	return empMapper.selectByDeptno(deptno); 
//}
//
//
//public Emp selectByDeptnoWithDept(int deptno){
//	
//	return empMapper.selectByDeptnoWithDept(deptno) ;
//	
//}
	
	
	
}
