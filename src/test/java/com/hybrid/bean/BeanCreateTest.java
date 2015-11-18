package com.hybrid.bean;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.hybrid.model.Member;

public class BeanCreateTest {

	static Log log = LogFactory.getLog(BeanCreateTest.class); 
	
	static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("com/hybrid/bean/beans.xml"); 
//	beans.xml <- new - other - spring - spring bean configuration file - beans.xml 
	
	
	public static void main(String[] args) throws InterruptedException, ParserConfigurationException, SAXException, IOException {

		test1(); // spring에서 객체를 생성하는 첫번째 방법 -  new 를 이용한 방법 
		test2(); // spring에서 객체를 생성하는 두번째 방법 -  factory 를 xml 에 설정하여 이용하는 방법 
		
		Document document = ctx.getBean(Document.class) ; 
		Element root = document.getDocumentElement(); 
		log.info("2nd root = " + root.getNodeName()) ; 
		
	
	}
	
	
		static void test2() throws ParserConfigurationException, SAXException, IOException {
//		factory method 를 통해 두 번째 객체 생성 방법 
		
//		beans.xml 의 두 번째 bean에서 method-type을 통해 newInstance()를 생성 
//		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance() ;
//		ctx.getBean(DocumentBuilderFactory.class) ; 
		
		DocumentBuilderFactory f = ctx.getBean(DocumentBuilderFactory.class) ; 
		DocumentBuilder builder = f.newDocumentBuilder() ;

		
		ClassPathResource resource = new ClassPathResource("com/hybrid/bean/dept.xml") ; // spring 에서 inputstream을 사용하기 위해 
		
		Document document = builder.parse(resource.getInputStream()) ;
		Element root = document.getDocumentElement(); // root element 
		log.info("1st root = " + root.getNodeName());

		
	}
	
	
		static void test1() throws InterruptedException{
		
		Date d = ctx.getBean(Date.class); 
		log.info("Date = " + d);
		
		Thread.sleep(2000); 
		
		Date d2 = ctx.getBean(Date.class); 
		log.info("Date = " + d2); 
		
		Member m = ctx.getBean(Member.class);
		Member m2 = ctx.getBean(Member.class) ; 
		
		m.setId(100);
		m.setEmail("xxx@yyyy");
		
		
		log.info(m2.getId() + "\t" + m2.getEmail());
		
	}

}







