package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

public class DeptDao {
	
	
	static Log log = LogFactory.getLog(DeptDao.class) ; 
	
	DeptMapper mapper  ;
	
	public void setDeptMapper(DeptMapper mapper) {
		
		this.mapper = mapper  ;
		
	}
	
	public List<Dept> selectAll() {
		
//		log.info("### Start selectAll"); 
		
		List<Dept> list = mapper.selectAll() ;
		
		log.info("Dept size = " + list.size());
		
//		log.info("### End selectAll"); 
		
		return list ; 
		
//		return mapper.selectAll() ; 
	}
	
	
	public List<Dept> selectAllWithEmps() {
		
//		log.info("### Start selectAllWithEmps()"); 
		
		List<Dept> list = mapper.selectAllWithEmps() ;
		
		log.info("Dept size = " + list.size());
		
//		log.info("### End selectAllWithEmps"); 
		
		return list ;
		
//		return mapper.selectAllWithEmps() ; 
	}
	
	
	public Dept selectByDeptno(int deptno) {
	
		return mapper.selectByDeptno(deptno);
		
	}
	
	
	public Dept selectByDeptnoWithEmps(int deptno) {
		
		return mapper.selectByDeptnoWithEmps(deptno);
		
	}
	
	
	public int insert(Dept dept){
		
		
		
		return mapper.insert(dept) ; 
	}
	

}
