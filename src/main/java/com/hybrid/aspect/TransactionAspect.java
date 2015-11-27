package com.hybrid.aspect;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect // @aspect 를 쓰면 weaving 해야 함을 알 수 있다. 
public class TransactionAspect {
	
	static Log log = LogFactory.getLog(TransactionAspect.class) ; // Log 는 commons.logging
	
	DataSource dataSource ; // sql DatasSource 르 받아온다. 
	
	public void setDataSource(DataSource ds){
		
		this.dataSource = ds ; 
		
	}
	

	@Around("execution(public * com.hybrid.service.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		
		// before advice 가 수행되는 지점 
		
//		log.info("#### before "); 
		
		log.info("### Transaction Start");
		
		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource) ;
		TransactionDefinition td = new DefaultTransactionDefinition() ;
		TransactionStatus ts = tm.getTransaction(td) ; 
		
 		
		Object rtn = null ; // rtn : return 의 의미 
		
		try{
		
			rtn = pjp.proceed() ;
			// afterReturning 
//			log.info("### afterReturning");
			
			tm.commit(ts);
			log.info("### commit");
			
		}catch(Throwable t) {
			
			// afterThrowing 
//			log.info("### afterThrowing");
			tm.rollback(ts);
			log.info("### rollback");
			
			throw t ; 
			
		}finally{
			// after advice 가 수행되는 지점
//			log.info("### after");
			
		}
		
		
		return rtn ; 
	} 
	
	
}
