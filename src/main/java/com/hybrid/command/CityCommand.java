package com.hybrid.command;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.hybrid.exception.PasswordNotMatchingException;
import com.hybrid.model.City;

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

// @JsonIgnoreProperties 는 Citycommand class 를 제거하라(ignore)는 의미
@JsonIgnoreProperties(value="city") // postman 에서 출력이 제거됨, error message 만 출력딘다. 
public class CityCommand {

	private int Id ;
	private String Name ;
	private String CountryCode; 
	private String District ; 
	private Integer Population ;
	
	
	private Map<String, Object> errorMessage ; // Error message 를 Map 으로 error key 와 message 를 전달한다. 
	
	public CityCommand() {

		errorMessage = new HashMap<>(); 

	}

	public Map<String, Object> getErrorMessage(){
		
		
		return errorMessage; 
	}
	
	
	
	
	public void validate(){
		
		/*
		 * name validate
		 * */
		
		/*
		 * countryCode validate
		 * */
		
		/*
		 * district validate 
		 * */
		
		/*
		 * population validate
		 * */
		
		
	}
	
	
	
	public boolean isValid(){ 
		
//		if(errorMessage != null && errorMessage.size() > 0 ) // 1)
		
		if(errorMessage.size() > 0 )
		
		return false;
		
//		errorMessage = null ; // Error message 가 없으면 null 처리  // 1) 
		return true ; 
	}
	
	
	
	
	public City getCity(){
		
		City city = new City(); 
		city.setId(Id);
		city.setName(Name);
		city.setCountryCode(CountryCode);
		city.setDistrict(District);
		city.setPopulation(Population);
		
		return city ; 
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	} 
	
}






