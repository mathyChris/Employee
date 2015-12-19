package com.hybrid.model.busapi;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ServiceResult")
@XmlType(propOrder={"msgHeader","msgBody"})
public class ServiceResult {
	
	MsgHeader msgHeader ;
	
	MsgBody1 msgBody ; 



	public MsgHeader getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(MsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}
	
	public MsgBody1 getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(MsgBody1 msgBody) {
		this.msgBody = msgBody;
	}
	
}
