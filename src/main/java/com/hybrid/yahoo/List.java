package com.hybrid.yahoo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="list")
@XmlType(propOrder={"meta" , "resources"}) 
public class List {
	
	Meta meta ; 
	Resources resources ;
	
	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	public Resources getResources() {
		return resources;
	}
	
	public void setResources(Resources resources) {
		this.resources = resources;
	}
	
	
}
