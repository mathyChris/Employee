package com.hybird.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hybrid.mapper.MemberMapper;
import com.hybrid.model.Member;

public class MemberMapperTest {							/*connection 관리*/
	
	static Log log = LogFactory.getLog(MemberMapperTest.class);
	
	public static void main(String[] args) throws Exception {
		
//		test1(); 
//		test2(); 
//		test3();
		test4(); 
		
	}
	static void test4(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml") ;
		
		MemberMapper memberMapper = ctx.getBean(MemberMapper.class) ;
		
		List<Member> list = memberMapper.selectAll(); 
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				
				log.info("Name = " + m.getName());
				
			}
		});
		
		
	}
	
	static void test3(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml") ;
		
		SqlSessionTemplate sqlSession = ctx.getBean(SqlSessionTemplate.class) ;
		
		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll"); 
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				
				log.info("Name = " + m.getName());
				
			}
		});
		
	}
	
	
	static void test2(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml") ;
		
		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class) ;// ibatis class 
		SqlSession sqlSession = sqlSessionFactory.openSession(); 
		
		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		//ibatis 에서는 .selectAll 까지 써야 한다. 
		
		
//		java 8에서의 새로운 for 표현법 
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {

				log.info(m.getId() +"\t" + m.getName());
				
			}

		});
		
		
		
		
//		for(Member m : list){
//			
//			log.info( "id = " + m.getId()); 
//		}
		
	}
	
	static void test1() throws Exception{
	
		String driverClassName = "com.mysql.jdbc.Driver";		/*database connection - driver properties에 있음.*/
		String url = "jdbc:mysql://localhost:3306/world";		
		String username = "root";
		String password = "mysql";
		
		
		/*
		 * DataSource
		 */
		
		BasicDataSource  dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		/*
		 * SqlSessionFactoryBean
		 */
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		
		ClassPathResource memberMapper = new ClassPathResource("com/hybrid/mapper/MemberMapper.xml");
		Resource[] mapperLocations = {memberMapper};
		sqlSessionFactory.setMapperLocations(mapperLocations);
		
		
		/*
		 * SqlSessionTemplete
		 */
		
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory.getObject()); // 
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);		
		/* MemberMapper 인터페이스를 불러온다.mybatis에서만 인터페이스가 xml 형식을 불러 올수 있다.*/
		
		List<Member> list = mapper.selectAll();
		
//		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll");  옛날 방식

		for (Member m : list){
			log.info("id = " + m.getId());
			log.info("getEmail = " + m.getEmail());
			log.info("getName = " + m.getName());
			log.info("getPassword = " + m.getPassword());
			log.info("getResterDate = " + m.getRegisterDate());
			
		}
		
		
//		printMembers(dataSource.getConnection());
		log.info("Program exit....");
	}
	
	static void printMembers(Connection con) throws SQLException{
		String sql = "select * from member";
		Statement stmt =  con.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);
		
		List<Member> list = new ArrayList<>();
		
		while(rs.next()){
			//Object Relational Mapping(ORM)
			Member m = new Member();
			m.setId(rs.getLong("id"));
			m.setEmail(rs.getString("email"));
			m.setName(rs.getString("name"));
			m.setPassword(rs.getString("password"));
			m.setRegisterDate(rs.getDate("register_date"));
			list.add(m);
		}
		for (Member m : list){
			log.info("id = " + m.getId());
			log.info("getEmail = " + m.getEmail());
			log.info("getName = " + m.getName());
			log.info("getPassword = " + m.getPassword());
			log.info("getResterDate = " + m.getRegisterDate());
			
		}
		
		
	}
}
