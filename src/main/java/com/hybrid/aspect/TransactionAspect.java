package com.hybrid.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect // @aspect 를 쓰면 weaving 해야 함을 알 수 있다. 
public class TransactionAspect {
	
	static Log log = LogFactory.getLog(TransactionAspect.class) ; // Log 는 commons.logging

	@Around("execution(public * com.hybrid.service.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		
		// before advice 가 수행되는 지점 
		
		log.info("#### before "); 
		
		Object rtn = null ; // rtn : return 의 의미 
		
		try{
		
			rtn = pjp.proceed() ;
			// afterReturning 
			log.info("### afterReturning");
		
		}catch(Throwable t) {
			
			// afterThrowing 
			log.info("### afterThrowing");
			
			throw t ; 
			
		}finally{
			// after advice 가 수행되는 지점
			log.info("### after");
			
		}
		
		
		return rtn ; 
	} 
	
	
}
