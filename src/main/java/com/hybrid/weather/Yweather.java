package com.hybrid.weather;

public class Yweather {
	
	Location location ; 
	Units units ; 
	Wind wind ; 
	Atmosphere atmosphere  ;
	Astronomy astronomy ;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
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
	

}
