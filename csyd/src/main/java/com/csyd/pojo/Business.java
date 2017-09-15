package com.csyd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Business implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cusPhone;
	private String proName;
	private String busType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date busOpen;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date busClose;
	private Integer sellerId;
	private String busStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date busTime;
	private Double proMonth;
	private Double proFirst;
	private String sellerName;
	private String sellerPhone;

	public Business() {
	}

	@Override
	public String toString() {
		return "Business{" +
				"id=" + id +
				", cusPhone='" + cusPhone + '\'' +
				", proName='" + proName + '\'' +
				", busType='" + busType + '\'' +
				", busOpen=" + busOpen +
				", busClose=" + busClose +
				", sellerId=" + sellerId +
				", busStatus='" + busStatus + '\'' +
				", proMonth=" + proMonth +
				'}';
	}

	public Date getBusTime() {
		return busTime;
	}

	public void setBusTime(Date busTime) {
		this.busTime = busTime;
	}

	public Double getProFirst() {
		return proFirst;
	}

	public void setProFirst(Double proFirst) {
		this.proFirst = proFirst;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getBusType() {
		return this.busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Date getBusOpen() {
		return this.busOpen;
	}

	public void setBusOpen(Date busOpen) {
		this.busOpen = busOpen;
	}

	public Date getBusClose() {
		return this.busClose;
	}

	public void setBusClose(Date busClose) {
		this.busClose = busClose;
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	public Double getProMonth() {
		return proMonth;
	}

	public void setProMonth(Double proMonth) {
		this.proMonth = proMonth;
	}
}