package com.csyd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer proId;
	private String proName;
	private String proType;
	private String proCost;
	private String proLoc;
	private String proImg;
	private Double proFirst;
	private Double proMonth;
	private String proLink;
	private String proOut;
	private String proStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date proDate;

	public Product() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return this.proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getProCost() {
		return this.proCost;
	}

	public void setProCost(String proCost) {
		this.proCost = proCost;
	}

	public String getProLoc() {
		return this.proLoc;
	}

	public void setProLoc(String proLoc) {
		this.proLoc = proLoc;
	}

	public String getProImg() {
		return this.proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	public Double getProFirst() {
		return this.proFirst;
	}

	public void setProFirst(Double proFirst) {
		this.proFirst = proFirst;
	}

	public Double getProMonth() {
		return this.proMonth;
	}

	public void setProMonth(Double proMonth) {
		this.proMonth = proMonth;
	}

	public String getProLink() {
		return this.proLink;
	}

	public void setProLink(String proLink) {
		this.proLink = proLink;
	}

	public String getProOut() {
		return this.proOut;
	}

	public void setProOut(String proOut) {
		this.proOut = proOut;
	}

	public String getProStatus() {
		return this.proStatus;
	}

	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}

	public Date getProDate() {
		return this.proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

}