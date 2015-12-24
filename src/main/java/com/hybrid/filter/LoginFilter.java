package com.hybrid.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	
	static Log log = LogFactory.getLog(LoginFilter.class) ; 

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
			
		log.info("destroy()....");
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		log.info("doFilter()...");
		
		// 결국 session 을 사용하기 위해 HttpServletRequest 를 사용한다. 
		// servletRequest 나 servletResponse 로 처리가 안되므로, HttpServletRequest or HttpServletResponse 로 downcast 하여 사용한다. 
		HttpServletRequest req = (HttpServletRequest) request ; 
		HttpServletResponse res = (HttpServletResponse) response ;
		
		// session을 가져오기 위해서는  Downcasting 해야 한다. session 을 통해 login 정보를 처리한다. 
		HttpSession session = req.getSession() ; // login 이 안되어 있으면 session 이 null 
		
		Boolean login = (Boolean) session.getAttribute("login"); 
		
		
		if(login != null && login == true) // login true 인 경우 
		
			chain.doFilter(request, response); // 통과해라!! 는 의미 
		
		else { // login false 
			
			String context = req.getContextPath(); 
			// redirect 는 response 로 처리한다. 
			res.sendRedirect(context + "/user/login.html");
			
			
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		log.info("init().."); 
	}

}
