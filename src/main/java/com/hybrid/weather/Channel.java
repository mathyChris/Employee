package com.hybrid.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
	
	String title ; 
	String link ;
	String description ; 
	String language ; 
	String lastBuildDate ; 
	String ttl ; 
	
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Location location ; 
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Units units ; 
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Wind wind ; 
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Atmosphere atmosphere ; 
	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	Astronomy astronomy ; 
	
	Image image ;  
	Item item ;
	
	
	
	public Units getUnits() {
		return units;
	}
	public void setUnits(Units units) {
		this.units = units;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}
	public Astronomy getAstronomy() {
		return astronomy;
	}
	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}
	
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	} 
	
}
