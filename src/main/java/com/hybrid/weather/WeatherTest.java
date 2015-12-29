package com.hybrid.weather;

import org.springframework.web.client.RestTemplate;


public class WeatherTest {

	public static void main(String[] args) {

		RestTemplate rest = new RestTemplate(); 
		
		String url = "http://weather.yahooapis.com/forecastrss?w=1132599&u=c" ; 
		
		Rss rss = rest.getForObject(url, Rss.class) ;
		
		System.out.println("Test = " + rss.getChannel().getLocation().getCity());
		System.out.println("Test = " + rss.getChannel().getLocation().getCountry());
		System.out.println("Test = " + rss.getChannel().getLocation().getRegion());
		
		System.out.println("Test = " + rss.getChannel().getUnits().getDistance());
		System.out.println("Test = " + rss.getChannel().getUnits().getTemperature());
		System.out.println("Test = " + rss.getChannel().getUnits().getPressure());
		System.out.println("Test = " + rss.getChannel().getUnits().getSpeed());
		
		
		System.out.println("Test = " + rss.getChannel().getItem().getForecast().get(0).getHigh());
		
	}

}
