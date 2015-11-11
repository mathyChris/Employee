package com.hybird.mapper;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberMapperSpringTest {
	
	static Log log = LogFactory.getLog(MemberMapperSpringTest.class);

	public static void main(String[] args) throws SQLException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		/* XML 읽는 역할 */
		
		//BasicDataSource dataSource =  (BasicDataSource) ctx.getBean("oracleDataSource");
		/*xml의 bean id가 dataSource인 것을 가지고 옴. object 타입이라서 타입케스팅이 필요.*/
		
//		BasicDataSource dataSource = ctx.getBean(BasicDataSource.class);
		/*BasicDataSource 클래스를 사용하는 모든 bean id를 불러온다.mysql과 orcle이 두개 들어 있으면 error난다.*/
		
		BasicDataSource dataSource = ctx.getBean( "oracleDataSource",BasicDataSource.class);	//최종타입
		log.info("className = " + dataSource.getDriverClassName());
		log.info("url = " + dataSource.getUrl());
		log.info("username = " + dataSource.getUsername());
		log.info("password = " + dataSource.getPassword());
		
		Connection con = dataSource.getConnection();
		String productName = con.getMetaData().getDatabaseProductName();
		String productVersion = con.getMetaData().getDatabaseProductVersion();
		log.info("productName = " + productName);
		log.info("productVersion = " + productVersion);
	}

}
