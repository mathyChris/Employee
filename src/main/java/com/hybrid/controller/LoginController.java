package com.hybrid.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hybrid.command.LoginCommand;
import com.hybrid.exception.LoginFailException;
import com.hybrid.model.Member;
import com.hybrid.service.LoginService;

@Controller
@RequestMapping("/user") // URL 에 /user 가 붙는다. 
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	LoginService loginService;

	/*
	 * login.html
	 */
	@RequestMapping(value="/login.html", method=RequestMethod.GET)
	public String getLoginView() {
//	public String getLoginView(HttpSession session) {

//		log.info("getLoginView()....");
//		session.invalidate(); 
		
		return "user/login";		
	}
	
	//login 기능에 대해 생성 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginCommand login(@RequestBody LoginCommand command, HttpSession session) {
		
		log.info("email = " + command.getEmail());
		log.info("password = " + command.getPassword());

		Member member = loginService.login(command.getEmail(), command.getPassword());
		
		session.setAttribute("login", true);
		session.setAttribute("member", member);

		return command;
	}
	
	
	// logout 기능 구현 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		log.info("logout()...");
		
		session.invalidate();
		
		return "redirect:/user/login.html"; // redirect 를 사용하면 logout 한 후에 설정한  URL 경로로 다시 접속한다. 
//		return "redirect:/city/main.html" ; 
	}
	
	
	// 다음에 login 상태를 체크 하는 로직을 만든다. 
	@RequestMapping(value = "/logincheck", method=RequestMethod.GET)
	@ResponseBody 
	public Map<String, Object> logincheck(HttpSession session){
		
		Map<String, Object> map = new HashMap<>();
		
		Boolean login = (Boolean) session.getAttribute("login")  ; // 로긴 여부를 session으로 처리한다. 
		
		if(login != null && login == true){
			
			
			map.put("login", true) ; // login이 되어 있으면  이 true 라고 날아온다. 
			map.put("member", session.getAttribute("member")); // memeber info 까지 같이 날아오도록 한다. 
			
		}else {
			
			map.put("login", false); // 
			
		}
		
		return map ; 
	} 
	
	
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> loginfail(LoginFailException e) {
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("message", e.getMessage());

		return error;
	}

}
