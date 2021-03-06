package com.hybrid.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestMapping;

import com.hybrid.util.Pagination;


@XmlRootElement(name="ResponseCity")//xml로의 변환 대상임을 알려주는 annotation. 
@XmlAccessorType(XmlAccessType.FIELD) // Field 에 있는 이름으로 사용하도록 함
//@XmlAccessorType(XmlAccessType.values("city"))
public class CityPage {
	
	@XmlElementWrapper(name="cities") // cities로 감싸도록 하는 기능 
	@XmlElement(name="city")
	List<City> cities ;
	
	Pagination paging ;
	

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	
	public Pagination getPaging() {
		return paging;
	}

	
	
	public void setPaging(Pagination paging) {
		this.paging = paging;
	} 
	

}



