package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.command.CityCommand;
import com.hybrid.model.City;
import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.model.Dept;
import com.hybrid.model.DeptList;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;
import com.hybrid.service.CityRegisterService;
import com.hybrid.util.Pagination;

@Controller
@RequestMapping("/country") // City 라고 들어오면 이 Controller 로 처리해준다. 
public class CountryController {
	
	static Log log = LogFactory.getLog(CountryController.class); 
	
	@Autowired // 자동으로 필드에 DI 주입시킴
	CityListService cityListService; 
	
	@Autowired // field injection 
	CityPageService cityPageService ; 
	
	@Autowired // field injection 
	CityRegisterService cityRegisterService ; 
	
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
	
	/*
	 * main.html
	 * */
	
//	@RequestMapping("/city.html") // ==> main.thml  getView ==> getMainView 
	@RequestMapping(value="/main.html", method = RequestMethod.GET)
	public String getMainView(){

		log.info("getMainView()..."); 
		
//		return "city/city"; //  /WEF-INF/view/city/dept.jsp 로 return 할 것
		return "country/main"; //  /WEF-INF/view/city/main.jsp 로 return 할 것
	}
	
	/*
	 * list.html
	 * */
	
//	list.jsp의 mapping 처리 
	@RequestMapping(value = "/list.html" , method = RequestMethod.GET)
	public String getListView(){

		log.info("getListView()..."); 
		
		return "country/list"; 
	}
	
	
	/*
	 * detail.html (detail view)
	 * */
	
//	detail.jsp ==> detailControl.js ==> main.jsp
	@RequestMapping(value = "/detail.html" , method = RequestMethod.GET)
	public String getDetailView(){

		log.info("getDetailView()..."); 
		
		return "country/detail"; 
	}
	

	/*
	 * append.html (append view)
	 * */
	
//	append.jsp ==> appendControl.js ==> main.jsp
	@RequestMapping(value = "/append.html" , method = RequestMethod.GET)
	public String getAppendView(){

		log.info("getAppendView()..."); 
		
		return "country/append"; 
	}
	
	
	/*
	 * modify.html (modify view)
	 * */
	
//	modify.jsp ==> modifyControl.js ==> main.jsp
	@RequestMapping(value = "/modify.html" , method = RequestMethod.GET)
	public String getModifyView(){

		log.info("getModifyView()..."); 
		
		return "country/modify"; 
	}
	
	
	/*
	 * delete.html (delete view)
	 * */
	
//	delete.jsp ==> deleteControl.js ==> main.jsp
	@RequestMapping(value = "/delete.html" , method = RequestMethod.GET)
	public String getDeleteView(){

		log.info("getDeleteView()..."); 
		
		return "country/delete"; 
	}
	
	
	

	/*
	 *  GET_LIST =  [/city]  or  [/city/] 
	 *  Accept = application/json 
	 * */
	@RequestMapping(value={"" , "/"} ,  method = RequestMethod.GET) // value를 추가하면  "" 와 "/" 둘 다 처리한다.
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
		
		log.info("getCountryAll()... ");
	
		CityList list = cityListService.getList() ;
		
		return list ; 
	}
	
	
// Test로 추가 진행한 부분 
	@RequestMapping(value="/dept", method = RequestMethod.GET)
	@ResponseBody
	public DeptList getDeptAll(){
		
		log.info("addDept()... ");
		
		DeptList list = new DeptList(); 
		
		List<Dept> depts = new ArrayList<Dept>(); 
		Dept dept = new Dept(); 
		dept.setDeptno(70);
		dept.setDname("Strategy");
		
		depts.add(dept)  ;
		
		list.setList(depts);
		
		return list ; 
	}
	
	/*
	 * URL_GET_ITEM_BASE = [/city/{id}]  // url 이  /city/{id}의 형식으로 요청이 들어오면 아래 동작.....
	 * Accept = application.json
	 * */
	@RequestMapping(value = "/{id:[0-9]+}" , method = RequestMethod.GET)
	@ResponseBody
	public City getCityItem(@PathVariable int id){
		
		log.info("getCityItem()... id = " + id); 
		
		City city = new City(); 
		city.setId(id);
		city.setName("SEOUL");
		
		return city  ;
	}
	
	
	
	
	
	/*
	 *  GET_PAGE =  [/city/page/{pageNo}]
	 *  Accept = application/json 
	 * */
//	@RequestMapping("/page/{pageNo}")
//	@RequestMapping("/page/{pageNo:[0-9][0-9][0-9]}") // [0-9]는 정규 표현식, 한자리씩을 의미, 여기는 3자리만 된다는 뜻 , 왜? []가 3개 있으니...
//	@RequestMapping("/page/{pageNo:[0-9]+}") // +의 의미는 한자리 수 이상 넣어라.
//	@RequestMapping("/page/{pageNo:[\\-\\+\\*]{0,1}[0-9]+}") //{0,1} 의미는 앞자리가 있거나 없거나의 조건 주는 것  , - 는 \\로 감싸서 
	@RequestMapping(value = "/page/{pageNo:[\\-\\+]{0,1}[0-9]+}" , method = RequestMethod.GET)
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
	
		log.info("getCityPage()...pageNo = " + pageNo) ;
		
		CityPage cities = cityPageService.getPage(pageNo) ;
		
		return cities;
	}
	
	
	/*
	 * URL_POST_ITEM_APPEND = [/city] or [/city/]
	 * Accept = application/json
	 * */
	@RequestMapping(value={"", "/"}, method = RequestMethod.POST)
	@ResponseBody // return type ==> change to 'json type' in responseBody  
//	public List<City> postCityAppend(@RequestBody List<City> cities){ // @RequestBody : json ==> City type 
		
	public CityCommand postCityAppend(@RequestBody CityCommand command){
	
//		log.info("postCityAppend()... cities' size = " + cities.size());
		
		log.info("postCityAppend()... city id = " + command.getId());
		
		
		// 아래 두 개 method 에서 검증되어야 하단 등록 기능(cityRegisterService.regist(command.getCity()) )이 실현된다. 
		command.validate();
//		command.isValid(); 
		
		if(!command.isValid()) {
			
			// throw 
		}
		
		
		int id = cityRegisterService.regist(command.getCity()); 
		command.setId(id); // postman으로 확인 
	
		return command ; 
		
//		return cities ; 
		
	}
	
	
	
	/*
	 * URL_PUT_MODIFY = [/city/{id}] // to change the old data 
	 * Accept = application/json
	 * 
	 * put = update 
	 * */
	@RequestMapping(value="/{id:[0-9]+}" , method = RequestMethod.PUT)
	@ResponseBody 
	public CityCommand putCityModify(@PathVariable int id,  @RequestBody CityCommand city){
		log.info("putCityModify()... id = " + id);
		
		log.info("putCityModify()... city id = " + city.getId());
	
		return city ; 
		
		
	}
	
	
	/*
	 * DELETE_ITEM_DELETE_BASE = [/city/{id}] // to delete the old data 
	 * Accept = application/json
	 * 
	 * */
	@RequestMapping(value="/{id:[0-9]+}" , method = RequestMethod.DELETE)
	@ResponseBody 
	public CityCommand deleteCity(@PathVariable int id){
		log.info("deleteCity()... id = " + id);
		
		CityCommand city = new CityCommand(); 
		
		city.setId(id);
	
		return city ; 
		
		
	}
	
	

}








