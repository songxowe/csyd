package com.csyd.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Vbus implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sellerPhone;
	private String joinerName;
	private String cusPhone;
	private String busType;
	private String proName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date busOpen;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date busClose;
	public Vbus() {
		
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getJoinerName() {
		return joinerName;
	}
	public void setJoinerName(String joinerName) {
		this.joinerName = joinerName;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Date getBusOpen() {
		return busOpen;
	}
	public void setBusOpen(Date busOpen) {
		this.busOpen = busOpen;
	}
	public Date getBusClose() {
		return busClose;
	}
	public void setBusClose(Date busClose) {
		this.busClose = busClose;
	}
	@Override
	public String toString() {
		return "Vbus [sellerPhone=" + sellerPhone + ", joinerName=" + joinerName + ", cusPhone=" + cusPhone
				+ ", busType=" + busType + ", proName=" + proName + ", busOpen=" + busOpen + ", busClose=" + busClose
				+ "]";
	}
	

}
