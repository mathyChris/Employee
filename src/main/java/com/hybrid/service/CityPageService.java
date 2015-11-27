package com.hybrid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;
import com.hybrid.model.CityPage;
import com.hybrid.util.Pagination;

public class CityPageService {
	
	
	CityDao cityDao ;
	
	public void setCityDao(CityDao cityDao){
		
		this.cityDao = cityDao ; 
		
	}
	
	
	
	@Transactional // @Transactional있으면 Dao 가 유dp Connection 을 하지 않는다. 
	public CityPage getPage(int pageNo){
		
		
		Pagination paging = new Pagination(); 
		paging.setPageNo(pageNo);
		paging.setTotalItem(cityDao.selectCount()); // Dao 가 있으면  사용할 때마다 connection 을 해야 한다. 성능상 불리함
		
		List<City> list = cityDao.selectPage(paging) ;
		
		CityPage page = new CityPage(); 
		page.setPaging(paging);
		page.setCities(list);
		
		return page ; 
	}

}
