package com.hybrid.model.busapi2;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ServiceResult")
@XmlType(propOrder={"msgHeader" , "msgBody"}) //xml 이 출력될 때, 순서가 뒤바뀌는데 원래대로 순서에 따라 출력되도록 함.
public class ServiceResult {

	MsgHeader msgHeader;
	MsgBody msgBody;

	public MsgHeader getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(MsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}

	public MsgBody getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(MsgBody msgBody) {
		this.msgBody = msgBody;
	}
	
	
	
}
