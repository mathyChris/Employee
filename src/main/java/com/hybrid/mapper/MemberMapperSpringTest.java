package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberMapperSpringTest {
	
		static Log log = LogFactory.getLog(MemberMapperSpringTest.class); 

		public static void main(String[] args) throws SQLException{

			GenericXmlApplicationContext ctx =  new GenericXmlApplicationContext("spring/beans_dao.xml") ;
			//GenericXmlApplicationContext은 bean 을 가지는 공장을 짓는다. DI container라 한다. 객체 조립기
			// spring/beans_dao.xml 로 가서 bean으로 표시된 것들의 정보를 이용해 객체를 조립한다. 
			
// 1. 			
//			factory 에서 가져오는 방법은 2가지가 있다. 이름으로 & type으로 가져오는 경우 
//			BasicDataSource dataSource = (BasicDataSource) ctx.getBean("mySqlDataSource") ; // data 이름으로 가져오는 경우 
//			BasicDataSource dataSource = (BasicDataSource) ctx.getBean("oracleDataSource") ; 
			

// 2. 			
//			BasicDataSource dataSource = ctx.getBean(BasicDataSource.class); //type으로 가져오는 경우 
			
			
// 3. 		다음은 class type 과 이름으로 구분하는 경우 (beans_dao.xml에 여러개의 bean 이 있는 경우에 사용)
//			BasicDataSource dataSource = ctx.getBean("mySqlDataSource", BasicDataSource.class) ;
		
			
// 4.		다음은 db.properties 파일에서 db 정보를 가져와 쓰는 경우 이름을 dataSource 변경한 경우에 해당한다. 
			BasicDataSource dataSource = ctx.getBean("dataSource", BasicDataSource.class) ;
			
//			System.out.println(dataSource.getUrl());
			
//			log.info(dataSource.getDriverClassName());
//			log.info(dataSource.getUrl());
//			log.info(dataSource.getUsername());
//			log.info(dataSource.getPassword());
			
			
			
//			지금 사용 중인 DB가 어떤 것인지 확인 하는 방법 
			Connection con = dataSource.getConnection(); 
			
			
			String productName = con.getMetaData().getDatabaseProductName() ;
			
			log.info("DB name = " + productName ); 
			
			String productVersion = con.getMetaData().getDatabaseProductVersion() ;
			
			log.info(productVersion); 
			
		}
}



