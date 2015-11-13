package com.hybrid.model;

import java.util.Date;

import com.hybrid.exception.PasswordNotMatchingException;

/*
 * DB 의 값을  자바 객체로 담기 위해 생성하는 클래스 
 * 
 * 이같은 목적으로 현재 만든 Member class 를 다음과 같이 부른다. 
 * 
 * Model object
 * Value object
 * Transfer object
 * 
 * 
 * Beans (Bean 규약에 맞도록 작성된 class를 beans라 한다.)
 * Bean 의 규약은 다음과 같다. 
 * 1. Property ==> setter, getter 를 property라 부른다. 
 * 2. Event 
 * 3. 기능 (method) 
 * 
 * property 는 데이터를 저장하는 속성을 가진다.
 * HTML = 속성, css = property라 한다. 
 * 
 * Bean 에서의 property 들은 component라 부른다. component 는 독립적인 단위의 기능(method)라 한다. 
 * 
 * 
 * */

public class City {

	private int Id ;
	private String Name ;
	private String CountryCode; 
	private String District ; 
	private Integer Population ;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public void setPopulation(Integer population) {
		Population = population;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	} 
	
	
	
	
}






