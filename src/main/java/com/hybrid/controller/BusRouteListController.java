/*


package com.hybrid.controller;

import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.hybrid.model.busapi2.ServiceResult;

@Controller
@RequestMapping("/busRouteInfo")
public class BusRouteListController {
	
	static Log log = LogFactory.getLog(BusRouteListController.class) ;
	
	@RequestMapping("/getBusRouteList/{strSrch}")
	@ResponseBody
	public ServiceResult getBusRouteList(@PathVariable String strSrch){
		
		log.info("getBusRouteList .. strSrch = " + strSrch);
		
		
		RestTemplate rest = new RestTemplate() ; // bean 설정에 넣어서 없앨 수 있다. 
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}"; // 개발 가이드 / 요청 주소 
		String serviceKey = URLDecoder.decode("s8HvbWYxtg7rY%2FNlvj4%2F6feKJu66XO%2BLNI3zC%2B7KEUdV0R1Iu2%2B33bKui8OAE%2BV6uJXTKtb9Hcnp94LSG4fajA%3D%3D") ; 
		
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey) ; 
		
		
		return new ServiceResult(); 
	}
	
}

*/


package com.hybrid.controller;

import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.hybrid.model.busapi2.ServiceResult;

@Controller
@RequestMapping("/busRouteInfo")
public class BusRouteListController {
	static Log log = LogFactory.getLog(BusRouteListController.class);
	
	@RequestMapping("/getBusRouteList/{strSrch}")
	@ResponseBody // jaxB 에게 unMarshaling 하라는 신호는 주는 부분 
	public ServiceResult getBusRouteList(@PathVariable String strSrch) {
		log.info("getBusRouteList().. strSrch=" + strSrch);
		
		RestTemplate rest = new RestTemplate();
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}";
		String serviceKey = URLDecoder.decode("s8HvbWYxtg7rY%2FNlvj4%2F6feKJu66XO%2BLNI3zC%2B7KEUdV0R1Iu2%2B33bKui8OAE%2BV6uJXTKtb9Hcnp94LSG4fajA%3D%3D");
		// Marshaling 하는 부분 
		
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey);
				
		return result;
	}

}















