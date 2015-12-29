package com.hybrid.yahoo;

import org.springframework.web.client.RestTemplate;


public class yahooFXTest {

	public static void main(String[] args) {

		RestTemplate rest = new RestTemplate(); 
		
		String url = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote"; 
		
		List list = rest.getForObject(url, List.class) ; 
		
		System.out.println("Type = " + list.getMeta().getType());
		System.out.println("=========================================");
		
		
//		System.out.println("Name = " + list.getResources().getResource().get(0).getField().get(1).getName());
//		System.out.println("Value = " + list.getResources().getResource().get(0).getField().get(1).getValue());
		
		int sizeResource = list.getResources().getResource().size() ;
		int sizeField = list.getResources().getResource().get(0).getField().size() ;
		
//		System.out.println("Size of Resource= " + sizeResource);
//		System.out.println("Size of Field = " + sieField);
		
		for(int j = 0 ; j < sizeResource ; j++ ) {
		
			for(int i = 0 ; i < sizeField ; i++ ){
				
//				System.out.println("Name = " + list.getResources().getResource().get(j).getField().get(i).getName() );
//				System.out.println("Value = " + list.getResources().getResource().get(j).getField().get(i).getValue());
				System.out.println("[" + (j+1) + "] " +  list.getResources().getResource().get(j).getField().get(i).getName() + " : " + list.getResources().getResource().get(j).getField().get(i).getValue());
				
				
			}
			
			System.out.println("=========================================");
		
		}
		
	}

}
