package com.hybrid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityControllerCopy {

	public String getView(){
		
		return "city/city"; 
	}
	
}
