package com.hybrid.model.busapi;

import java.net.URLDecoder;

import org.springframework.web.client.RestTemplate;

public class BusRouteListTest {
	
	public static void main(String[] args){
		
//		URL을 사용하여 경로를 주어 data 받음. 
		
		RestTemplate rest = new RestTemplate() ;
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}"; // 개발 가이드 / 요청 주소 
		// 노선 번호 , 서비스 키 정보만 있으면 된다. ?strSrch={strSrch}&serviceKey={serviceKey} 을 추가
		
		String strSrch = "6628"; 
		String serviceKey = URLDecoder.decode("s8HvbWYxtg7rY%2FNlvj4%2F6feKJu66XO%2BLNI3zC%2B7KEUdV0R1Iu2%2B33bKui8OAE%2BV6uJXTKtb9Hcnp94LSG4fajA%3D%3D") ; 
		// serviceKey 는 기본적으로 encoding 이 되어 있다.RestTemplate 는 기본으로 encoding 을 하기 때문에 decoding 을 해줘야 한다. 
		// 따라서 URLDecode를 사용 
		
		
//		String result = rest.getForObject(url, String.class, strSrch, serviceKey) ; 
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey) ; 
	
		//1. jsxb 에서 인식할 수 있는 객체 타입이 아니기 때문에 Error 발생 ==> @xmlrootelement 추가 
		
		System.out.println(result.getMsgHeader().getHeaderCd()); 
		System.out.println(result.getMsgHeader().getHeaderMsg()); 
		System.out.println(result.getMsgHeader().getItemCount()); 
		
		System.out.println("======================");
		
//		String busRouteId ; 
//		String busRouteNm ; 
//		String corpNm ; 
//		String edStationNm ; 
//		String firstBusTm ; 
//		String firstLowTm ; 
//		String lastBusTm ; 
//		String lastBusYn ; 
//		String lastLowTm ; 
//		String length ; 
//		String routeType ; 
//		String stStationNm ; 
//		String term ;
		
	
		System.out.println("busRouteId = " + result.getMsgBody().getItemList().getBusRouteId());
		System.out.println("busRouteNm = " + result.getMsgBody().getItemList().getBusRouteNm());
		System.out.println("corpNm = " + result.getMsgBody().getItemList().getCorpNm());
		System.out.println("edStationNm = " + result.getMsgBody().getItemList().getEdStationNm());
		System.out.println("firstBusTm = " + result.getMsgBody().getItemList().getFirstBusTm());
		System.out.println("firstLowTm = " + result.getMsgBody().getItemList().getFirstLowTm());
		System.out.println("lastBusTm = " + result.getMsgBody().getItemList().getLastBusTm());
		System.out.println("lastBusYn = " + result.getMsgBody().getItemList().getLastBusYn());
		System.out.println("lastLowTm = " + result.getMsgBody().getItemList().getLastLowTm());
		System.out.println("length = " + result.getMsgBody().getItemList().getLength());
		System.out.println("routeType = " + result.getMsgBody().getItemList().getRouteType());
		System.out.println("stStationNm = " + result.getMsgBody().getItemList().getStStationNm());
		System.out.println("term = " + result.getMsgBody().getItemList().getTerm());
		
		
		System.out.println("======================");
		

		
		
	}

}





