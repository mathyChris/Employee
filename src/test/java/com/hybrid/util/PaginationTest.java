package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

	static Log log = LogFactory.getLog(PaginationTest.class)  ;
	
	public static void main(String[] args) {
		
//		DB의 data 값을 가져오기 위해 GenericXmlApplicationContext 사용 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml"); 
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		
		CityMapper cityMapper = ctx.getBean(CityMapper.class)  ;
		int totalItem = cityMapper.selectCount() ;
		
		System.out.println("Total Items = " + totalItem);
//////////////////////////////////////////////////////////////// 여기까지 새로 추가 		

		Pagination paging = new Pagination(); 
		
		Scanner sc = new Scanner(System.in); 
		
		while(true) { 
			
			System.out.print("\n Input the pageNo : " );
			int pageNo = sc.nextInt() ;
		
		paging.setPageNo(pageNo);
		paging.setTotalItem(totalItem);
		
		
		// 이 부분도 새로 추가 , selectPage(paging)을 통해 가져온 data 를 list 객체로 받는다. 
		List<City> list = cityMapper.selectPage(paging) ;
		
	// list 로 부터 data를 출력하는 code, 각 page마다 있는 firstItem과 lastItem 을 이용   
	for(int i = paging.getFirstItem() ; i <= paging.getLastItem() ; i++ ) {
			
			City c = list.get(i - paging.getFirstItem()) ; // 중요한 코드 ... 굉장히 중요한... 
			// list는 index 0 으로부터 값을 가지기 때문에 i에서 firstItem 을 빼준다. 
			
//			System.out.println(i + " item index = " + list.get(i).getId() );
			
			String line = c.getId() + "\t" + c.getCountryCode() +  "\t" +c.getName() ; 
			System.out.println(line);
			
		}
		
		
/*		
		for(int i = 0 ; i < paging.getLength() ; i++ ) {
			
			City c = list.get(i); 
			
//			System.out.println(i + " item index = " + list.get(i).getId() );
			
			String line = c.getId() + "\t" + c.getCountryCode() +  "\t" +c.getName() ; 
			System.out.println(line);
			
		}
		*/
		
		if(!paging.isFirstGroup()) 
			System.out.print("[previous]");
		else
			System.out.print("    ");
		
		for(int i = paging.getFirstPage() ; i <= paging.getLastPage() ; i++){
			
			System.out.printf("[%03d]" , i);
			
		}
		
		
		if(!paging.isLastGroup())
			System.out.print("[Next]");
		else
			System.out.print("     ");
		
		System.out.println();
		
		
		}
		
	}
	
	static void test1(){
		Pagination paging = new Pagination(); 
		
		for(int i = -2 ; i < 40 ; i++){
		
			paging.setPageNo(i); 
			paging.setTotalItem(380);
			
			String msg = "totalPage = " + paging.getTotalPage() + 
					"\t FirstGroup = " + paging.isFirstGroup() + 
					"\t FirstPage = " + paging.getFirstPage() + 
					"\t LastPage = " + paging.getLastPage() + 
					"\t PageNo = " + paging.getPageNo() + 
					"\t FirstItem = " + paging.getFirstItem() + 
					"\t LastItem = " + paging.getLastItem() + 
					"\t LastGroup = " + paging.isLastGroup() ; 
			
			System.out.println(msg);
		
		} // for 
	
	} // test1()

}
