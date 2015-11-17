package com.hybrid.bean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;

public class DocumentFactoryBean implements FactoryBean<Document>{ // Document type- w3c 
//	FactoryBean<Document>를 만들면 기본 3개의 method 가 생성된다. 

	DocumentBuilderFactory factory ; 
	
	Document document ; 
	
	ClassPathResource resource ; 
	
	public DocumentFactoryBean(DocumentBuilderFactory factory) {

		this.factory = factory ;
	
	}
	
	
	// 생성되는 기본 파일은 아니다. 
	public void setPath(String path){
		
		resource = new ClassPathResource(path)  ;
		
	}
	
	
	
	@Override
	public Document getObject() throws Exception {
		
		if(document == null) {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
	//		setPath("com/hybrid/bean/dept.xml") ; 
			document = builder.parse(resource.getInputStream())  ;
			
		}
		
		return document ;
	}
	

	@Override
	public Class<?> getObjectType() { // DocumentFactory 가 만들어 내는 type 을 return 
		
		
		return Document.class ;
	}

	@Override
	public boolean isSingleton() {

		
//		return true; // true 로 놓으면 singleton 으로 변환 
		return false ; 
	}
	
	

}





