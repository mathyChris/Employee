package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.City;
import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.model.Dept;
import com.hybrid.model.DeptList;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;
import com.hybrid.util.Pagination;

@Controller
@RequestMapping("/city") // City 라고 들어오면 이 Controller 로 처리해준다. 
public class CityController {
	
	static Log log = LogFactory.getLog(CityController.class); 
	
	@Autowired // 자동으로 필드에 DI 주입시킴
	CityListService cityListService; 
	
	@Autowired // field injection 
	CityPageService cityPageService ; 
	
//////////////////////////////////////////////////////////////////// 수동으로 method 설정 
/*	
	public void setCityListService(CityListService service){
		
		this.cityListService = service ; 
		
	}
	
	public void setCityPageService(CityPageService service){
		
		this.cityPageService = service ; 
		
	}
	*/
/////////////////////////////////////////////////////////////////////	
	
//	@RequestMapping("/city.html") // ==> main.thml  getView ==> getMainView 
	@RequestMapping("/main.html")
	public String getMainView(){

		log.info("getMainView()..."); 
		
//		return "city/city"; //  /WEF-INF/view/city/dept.jsp 로 return 할 것
		return "city/main"; //  /WEF-INF/view/city/main.jsp 로 return 할 것
	}
	
	
	
//	list.jsp의 mapping 처리 
	@RequestMapping("/list.html")
	public String getListView(){

		log.info("getListView()..."); 
		
		return "city/list"; 
	}
	
	
//	detail.jsp ==> detailControl.js ==> main.jsp
	@RequestMapping("/detail.html")
	public String getDetailView(){

		log.info("getDetailView()..."); 
		
		return "city/detail"; 
	}
	
	
	

	@RequestMapping(value={"","/"}) // value를 추가하면  "" 와 "/" 둘 다 처리한다.
	@ResponseBody // return 값을 jsp 의 view-name이 아니라 data 그대로 인식. 이게 없으면 view-name로 인식   
//	public String getCityAll(){
/*	
	public CityList getCityAll(){
		
		CityList list = new CityList(); 
		
		List<City> cities = new ArrayList<City>(); 
		
		City city = new City();
		city.setId(100);
		city.setName("Seoul");
		city.setPopulation(100);
		cities.add(city); 
		
		City city2 = new City();
		city2.setId(200);
		city2.setName("Pusan");
		city.setPopulation(100);
		cities.add(city2); 
		
		list.setCities(cities);
		
//		return "1234"; 
		
		return list ; 
	}
*/	
	public CityList getCityAll(){
	
		CityList list = cityListService.getList() ;
		
		return list ; 
	}
	
	
// Test로 추가 진행한 부분 
	@RequestMapping(value="/dept")
	@ResponseBody
	public DeptList getDeptAll(){
		
		DeptList list = new DeptList(); 
		
		List<Dept> depts = new ArrayList<Dept>(); 
		Dept dept = new Dept(); 
		dept.setDeptno(70);
		dept.setDname("Strategy");
		
		depts.add(dept)  ;
		
		list.setList(depts);
		
		return list ; 
	}
	
	
//	@RequestMapping("/page/{pageNo}")
//	@RequestMapping("/page/{pageNo:[0-9][0-9][0-9]}") // [0-9]는 정규 표현식, 한자리씩을 의미, 여기는 3자리만 된다는 뜻 , 왜? []가 3개 있으니...
//	@RequestMapping("/page/{pageNo:[0-9]+}") // +의 의미는 한자리 수 이상 넣어라.
//	@RequestMapping("/page/{pageNo:[\\-\\+\\*]{0,1}[0-9]+}") //{0,1} 의미는 앞자리가 있거나 없거나의 조건 주는 것  , - 는 \\로 감싸서 
	@RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")
	@ResponseBody
//		public CityPage getCityPage(@PathVariable int pageNo) { // @PathVariable
//		
//		log.info("pageNo = " + pageNo);
//		
//		CityPage cities = new CityPage();
//		
//		Pagination paging = new Pagination(); 
//		
//		paging.setPageNo(pageNo);
//		paging.setTotalItem(4079);
//		
//		cities.setPaging(paging);
//		
//		return cities;
//	}
	

	public CityPage getCityPage(@PathVariable int pageNo) { // @PathVariable
	
		CityPage cities = cityPageService.getPage(pageNo) ;
		
		return cities;
	}

}








