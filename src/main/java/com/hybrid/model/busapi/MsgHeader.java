package com.hybrid.model.busapi;

public class MsgHeader {
	
	
//	<headerCd>0</headerCd>
//	<headerMsg>정상적으로 처리되었습니다.
//	</headerMsg>
//	<itemCount>0</itemCount>
	
	String headerCd ; 
	String headerMsg ; 
	int itemCount ; 
	
	public String getHeaderCd() {
		return headerCd;
	}
	public void setHeaderCd(String headerCd) {
		this.headerCd = headerCd;
	}
	public String getHeaderMsg() {
		return headerMsg;
	}
	public void setHeaderMsg(String headerMsg) {
		this.headerMsg = headerMsg;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	

}
