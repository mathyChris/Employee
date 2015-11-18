package com.hybrid.util;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PaginationTest {

	static Log log = LogFactory.getLog(PaginationTest.class)  ;
	
	public static void main(String[] args) {

		Pagination paging = new Pagination(); 
		
		Scanner sc = new Scanner(System.in); 
		
		while(true) { 
			
			System.out.print("\n Input the pageNo : " );
			int pageNo = sc.nextInt() ;
		
		paging.setPageNo(pageNo);
		paging.setTotalItem(4079);
		
		for(int i = paging.getFirstItem() ; i <= paging.getLastItem() ; i++ ) {
			
			System.out.println(" item index = " + i );
			
		}
		
		
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
		
		}
	
	}

}
