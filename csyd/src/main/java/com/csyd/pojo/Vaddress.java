package com.csyd.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Vaddress implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer count;
	private String proName;
	private String sellerName;
	private Integer sellerId;
	private String  busType;
	private String sellerLoc;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date busOpen;
	
	
	@Override
	public String toString() {
		return "Vaddress [count=" + count + ", proName=" + proName + ", sellerName=" + sellerName + ", sellerId="
				+ sellerId + ", busType=" + busType + ", sellerLoc=" + sellerLoc + ", busOpen=" + busOpen + "]";
	}
	public Date getBusOpen() {
		return busOpen;
	}
	public void setBusOpen(Date busOpen) {
		this.busOpen = busOpen;
	}
	public Vaddress() {
		
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSellerLoc() {
		return sellerLoc;
	}
	public void setSellerLoc(String sellerLoc) {
		this.sellerLoc = sellerLoc;
	}

}
