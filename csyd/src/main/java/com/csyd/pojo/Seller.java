package com.csyd.pojo;

import java.util.Date;

public class Seller implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer sellerId; //编号
	private String sellerName;//直销员姓名
	private String sellerPhone;//手机号
	private Integer joinerId;//所属代理商
	private Integer userId;//账户id
	private String sellerSex;//性别
	private String sellerCard;//证件类型
	private String sellerCardnum;//证件号
	private String sellerRemark;//备注
	private Date sellerDate;//加入时间
	private String sellerLoc;//所属地区
	//private String sellerFlag; // 状态
	private SysUser sysUser;
	private Joiner joiner;
	public Seller() {
	}

	public Joiner getJoiner() {
		return joiner;
	}

	public void setJoiner(Joiner joiner) {
		this.joiner = joiner;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

//	public String getSellerFlag() {
//		return sellerFlag;
//	}
//
//	public void setSellerFlag(String sellerFlag) {
//		this.sellerFlag = sellerFlag;
//	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPhone() {
		return this.sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public Integer getJoinerId() {
		return this.joinerId;
	}

	public void setJoinerId(Integer joinerId) {
		this.joinerId = joinerId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSellerSex() {
		return this.sellerSex;
	}

	public void setSellerSex(String sellerSex) {
		this.sellerSex = sellerSex;
	}

	public String getSellerCard() {
		return this.sellerCard;
	}

	public void setSellerCard(String sellerCard) {
		this.sellerCard = sellerCard;
	}

	public String getSellerCardnum() {
		return this.sellerCardnum;
	}

	public void setSellerCardnum(String sellerCardnum) {
		this.sellerCardnum = sellerCardnum;
	}

	public String getSellerRemark() {
		return this.sellerRemark;
	}

	public void setSellerRemark(String sellerRemark) {
		this.sellerRemark = sellerRemark;
	}

	public Date getSellerDate() {
		return this.sellerDate;
	}

	public void setSellerDate(Date sellerDate) {
		this.sellerDate = sellerDate;
	}

	public String getSellerLoc() {
		return this.sellerLoc;
	}

	public void setSellerLoc(String sellerLoc) {
		this.sellerLoc = sellerLoc;
	}

}