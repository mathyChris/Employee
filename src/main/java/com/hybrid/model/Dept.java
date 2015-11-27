package com.hybrid.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.hybrid.exception.PasswordNotMatchingException;



public class Dept {
	
	
	private int deptno ; 
	private String dname ; 
	private String loc ;
	private List<Emp> emps ; // "has-many" 라 한다.
	//
	//dept 에 대한 직원 정보도 가져오도록 설계한다면 이런 표현이 필요, 용도에 따른 사용성의 flexible 을 위해  
	// 필수적인것은 아니다. 그러나 다른 사용 예에 따른 사용성의 편의를 위해 ... 
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	} 
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	
	

}






