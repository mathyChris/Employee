package com.hybrid.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ibm.icu.text.TimeZoneNames.NameType;


@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	String title ; 
	
	@XmlElement(namespace="http://www.w3.org/2003/01/geo/wgs84_pos#")
	String lat ; 
	@XmlElement(name="long", namespace="http://www.w3.org/2003/01/geo/wgs84_pos#")
	String lng ;
	
	String link ; 
	String pubDate ; 
	
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Condition condition ; 
	
	String description ; 
	
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	List<Forecast> forecast ; 
	
	String guid ;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public List<Forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	

}
