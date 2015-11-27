package com.hybrid.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// 1. @를 치고 ctl + space 를 하여 aspect를 찾는다. 
public class LogAspect {
	
//	static Log log = LogFactory.getLog(LogDaoAspect.class) ; 
	
	
	// 4. Pointcut 생성 -> "execution(public * com.hybrid.dao.*Dao.*(..))" 를 공통으로 묶는다. 
	@Pointcut("execution(public * com.hybrid.dao.*Dao.*(..))")
//	public void logcut(){
//		
//		
//	}
	public void dao(){
		
		
	}
	
	
	// 12. service 부분 추가 , 이 부분 새로 생성 --> logcut() 부분을 dao()로 변경 --> service() 추가 
	@Pointcut("execution(public * com.hybrid.service.*Service.*(..))")
	public void service(){
		
		
	}
	
	
	
	
//	@Before("execution(public * com.hybrid.dao.*Dao.*(..))") // 2. method 수행 전 삽입되어 수행 
	//"execution(public * com.hybrid.dao.*Dao.*(..))"는 pointcut을 weaving 하는 부분 
	// * 는 return type , (..)의 .. parameter 
	
//	@After("logcut()")
	@Before("dao() || service()") // 5. logcut 으로 대체 
	public void before(JoinPoint jp){ // 7. jointpoint 는 join하려는 부분, pointcut 한 부분을 객체로 만들어 정보를 넘겨준다. 
		
		Log log = LogFactory.getLog(jp.getClass()); // 8. jp로 부터 class 정보를 넘겨 받는다. 
		log.info("### " + jp.getSignature().getName() // 10. jp로부터 클래스 이름을 받아온다.  
						+ "( "
						+ Arrays.toString(jp.getArgs()) // 9. Arrays.toString() 을 사용하여 배열 출력
						+ " )"
						+ " Start");
	} 
	
	
//	@After("execution(public * com.hybrid.dao.*Dao.*(..))") // 3.  method 수행 후 삽입되어 수행 
//	@After("logcut()") // 6. logcut 으로 대체 
	@After("dao() || service()") 
	public void after(JoinPoint jp){
		
		Log log = LogFactory.getLog(jp.getClass()) ; //  8. jp로 부터 class 정보를 넘겨 받는다. 
		log.info("### " + jp.getSignature().getName() // 10. jp로부터 클래스 이름을 받아온다.  
						+ "( "
						+ Arrays.toString(jp.getArgs()) // 11. join point 의 parameter를 읽어온다 . 
						+ " )"
						+ " End "); 
		
	}

}





