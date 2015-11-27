package com.hybrid.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ResponseDept") // 이 부분이 반드시 있어야 xml 파일이라는 것을 인지한다. 
@XmlAccessorType(XmlAccessType.FIELD)
public class DeptList {

	@XmlElementWrapper(name="Depts")
	@XmlElement(name="Dept")
	List<Dept> list ;

	public List<Dept> getList() { // getList에서 list만을 이름처럼 web browser로 보낸다. 
		return list;
	}

	public void setList(List<Dept> list) {
		this.list = list;
	} 

	
}
