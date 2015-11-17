package com.hybrid.model;

import java.util.Date;

import com.hybrid.exception.PasswordNotMatchingException;

public class Emp {
	
	private int empno;
	private String ename; 
	private String job ; 
	private Integer mgr ; 
	private Date hiredate ; 
	private Float sal ; 
	private Float comm ; // wrapper type 으로 ... null 값을 갖기 때문에...
	private int deptno ;
	private Dept dept; // "has-one"이라 한다. 
	// deptno 를 dept 에서 가져 오기 위해  Dept 객체로 받는다.
	// foreign key 와 비슷한 표현 , emp inner join dept 로 했을 때 출력 하는 방식을 표현 
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Float getSal() {
		return sal;
	}
	public void setSal(Float sal) {
		this.sal = sal;
	}
	public Float getComm() {
		return comm;
	}
	public void setComm(Float comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	} 
	
	
}






