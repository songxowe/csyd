package com.csyd.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Vbusiness implements Serializable{

	private static final long serialVersionUID = 1L;
private String sellerPhone;
 private String cusPhone;
 private String proName;
 private String sellerLoc;
 private String organName;
 private String busType;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date busOpen;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date busClose;
public Vbusiness() {
	
}

@Override
public String toString() {
	return "Vbusiness [sellerPhone=" + sellerPhone + ", cusPhone=" + cusPhone + ", proName=" + proName + ", sellerLoc="
			+ sellerLoc + ", organName=" + organName + ", busType=" + busType + ", busOpen=" + busOpen + ", busClose="
			+ busClose + "]";
}

public String getSellerPhone() {
	return sellerPhone;
}
public void setSellerPhone(String sellerPhone) {
	this.sellerPhone = sellerPhone;
}
public String getCusPhone() {
	return cusPhone;
}
public void setCusPhone(String cusPhone) {
	this.cusPhone = cusPhone;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public String getSellerLoc() {
	return sellerLoc;
}
public void setSellerLoc(String sellerLoc) {
	this.sellerLoc = sellerLoc;
}
public String getOrganName() {
	return organName;
}
public void setOrganName(String organName) {
	this.organName = organName;
}
public String getBusType() {
	return busType;
}
public void setBusType(String busType) {
	this.busType = busType;
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
}
