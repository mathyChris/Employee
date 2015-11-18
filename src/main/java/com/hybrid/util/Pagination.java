package com.hybrid.util;

public class Pagination {
	
	/*
	 * read-write
	 * */
	private int totalItem ; // DB에서 가져오는 data, select count(*) from city 
	private int pageNo ; // request parameter pageNo 
	
	/*
	 * read-only 
	 * */
	private int totalPage ; 
	private int firstItem ;
	private int lastItem ; 
	private int firstPage ; 
	private int lastPage ; 
	
	/*
	 * read-write
	 * */
	private int itemsPerPage = 10 ; 
	private int pagesPerGroup = 10 ; 
	
	
	public void calculator(){
		
		
		/*
		 *  PageNo Validation 
		 *  in the case of that it requests pageNo < 0 
		 * */
		if(pageNo < 1) 
			pageNo = 1 ; 
	
		
		/*
		 * total page 
		 * */
		
		totalPage = totalItem / itemsPerPage ; 
			if(totalItem % itemsPerPage > 0) {
				
				totalPage++ ;
				
			}
			
		/*
		 *
		 * in the case of that it requests pageNo > totalPage,  
		 * */	
//		if(pageNo > totalPage)	
//			pageNo = totalPage ; 
		
		/*
		 * in the case of that totalItem = 0 
		 * */
//		if(totalPage == 0 )
//			pageNo = 1  ;
		
			
			
		/*
		 * 삼항 연산자를 이용한 방법 -> 위의 code 를 하나로 묶는다. 
		 * */	
		if(pageNo > totalPage)
			pageNo = (totalPage == 0 ) ? 1 : totalPage ; 
			
		
		

		firstItem = (pageNo - 1 ) * itemsPerPage + 1 ; 	
		
		lastItem = firstItem + itemsPerPage - 1 ; 
			if(lastItem > totalItem){
				
				lastItem = totalItem ; 
				
			}
			
		firstPage = ( pageNo - 1 ) / pagesPerGroup * pagesPerGroup + 1  ; 
		
		lastPage = firstPage + pagesPerGroup - 1 ; 
			if(lastPage > totalPage) {

				lastPage = totalPage ; 
				
			} 
			
			
			
	}
	
	
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		
		this.totalItem = totalItem;
		
		calculator(); 
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	public int getTotalPage() {
		return totalPage;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public int getLastItem() {
		return lastItem;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	
	
	public int getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public int getPagesPerGroup() {
		return pagesPerGroup;
	}
	public void setPagesPerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}

	
	// whether or the existence of previous tag & next tag to each group  
	public boolean isFirstGroup(){
		
		return (firstPage == 1) ? true : false ;  
	}
	
	public boolean isLastGroup(){
		
		
		return (lastPage == totalPage )? true : false ; 
		
	}
	
	
	
}
