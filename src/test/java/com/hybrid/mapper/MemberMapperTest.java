package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hybrid.model.Member;

public class MemberMapperTest {
	
	static Log log = LogFactory.getLog(MemberMapperTest.class) ;
	

	public static void main(String[] args) throws Exception {
		
		
		String driverClassName = "com.mysql.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/world" ; 
		String username = "root"; 
		String password = "mysql" ;
		
	
		/*
		 * DataSource
		 * 
		 * */
		BasicDataSource dataSource = new BasicDataSource() ; // 객체를 생성하는 것 
		
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url); // setter 로 주입 (DI)
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		
		
		/*
		 * SqlSessionFactoryBean
		 * 
		 * */
		// SqlSessionFactoryBean는 spring 것을 사용한다. 
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean() ;
		sqlSessionFactory.setDataSource(dataSource);
		
		ClassPathResource memberMapper = new ClassPathResource("com/hybrid/mapper/MemberMapper.xml");
		Resource[] mapperLocations = { memberMapper } ; 
		sqlSessionFactory.setMapperLocations(mapperLocations);
		
		
		
		/*
		 * SqlSessionTemplate 
		 *
		 * */
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory.getObject()) ;// 생성자 생성 후 주입 (DI) 
		
		
//		ibatis 2.0 부터 지원하던 방식  --> 뒤에 mapper interface 방식으로 변한다. 
		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll") ; 
		// parameter 에 String 이 들어가기 때문에 문법 check 이 되지 않는다는 단점이 존재한다.
		
		
		
		for(Member m : list){
			
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail()); 
			log.info("name = " + m.getName()); 
			log.info("password = " + m.getPassword()); 
			log.info("Register Date = " + m.getRegisterDate()); 
			
		}
		
		
		/*
		 * Mapper interface 는 namespace 와 똑같은 이름으로 만든다. 
		 * Mapper interface 를 만들면 code assist 를 사용할 수 있다는 장점이 있다. (종전 ibatis 방식과 다른 점)
		 *  
		 * */
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class) ; // 새로 생성한 interface 파일 
		List<Member> list2 = mapper.selectAll(); 
		
		for(Member m : list2){
			
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail()); 
			log.info("name = " + m.getName()); 
			log.info("password = " + m.getPassword()); 
			log.info("Register Date = " + m.getRegisterDate()); 
			
		}
		
		
//		dataSource.getConnection();
		
//		printMembers(dataSource.getConnection()); 
		
		log.info("Program exit..."); 
		
	}

	static void printMembers(Connection con) throws SQLException{
		
		String sql = "select *from member" ;
		
		Statement stmt = con.createStatement() ;
		
		ResultSet rs =  stmt.executeQuery(sql) ;
		
		List<Member> list = new ArrayList<>() ;
		
		while(rs.next()) {
			
//			log.info("id = " + rs.getLong("id"));
//			log.info("name = " + rs.getString("name")); 

			
			Member m = new Member(); 
			m.setId(rs.getLong("id")); 
			m.setEmail(rs.getString("email"));
			m.setName(rs.getString("name"));
			m.setPassword(rs.getString("password"));
			m.setRegisterDate(rs.getDate("register_date"));
			
			list.add(m); 
			
		} // myBatis는 이 부분을 없애주고 list 로 준다. 
		
		for(Member m : list){
			
			log.info("id = " + m.getId());
			log.info("email = " + m.getEmail()); 
			log.info("name = " + m.getName()); 
			log.info("password = " + m.getPassword()); 
			log.info("Register Date = " + m.getRegisterDate()); 
			
		}
		
	}
	
	
}






