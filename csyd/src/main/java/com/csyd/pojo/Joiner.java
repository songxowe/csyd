package com.csyd.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Joiner implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer joinerId;//编号
	private String joinerName;//代理商名称
	private Organ organ;//上级组织 //修改为对象
	private String joinerLoc;//所属地区
	private String joinerLinkname;//联系人姓名
	private String joinerPhone;//联系人手机
	private String joinerEmail;//邮箱地址
	private String joinerAddress;//联系地址
	private String joinerBank;//开户银行
	private String joinerHolder;//开户人
	private String joinerBanknum;//银行账号
	private String joinerExplain;//代理商描述
	private Integer joLevelId;//代理商级别
	private Integer joHeigherId;//上级代理商id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinerDate;//代理商申请日期
	private Integer userId;//用户表
	private String joinerStatus="0";//代理商审核状态
	private String joinerRemark;//不通过要写备注
	private String userFlag;


	public Joiner() {
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public Integer getJoinerId() {
		return this.joinerId;
	}

	public void setJoinerId(Integer joinerId) {
		this.joinerId = joinerId;
	}

	public String getJoinerName() {
		return this.joinerName;
	}

	public void setJoinerName(String joinerName) {
		this.joinerName = joinerName;
	}

	public Organ getOrgan() {
		return organ;
	}

	public void setOrgan(Organ organ) {
		this.organ = organ;
	}

	public String getJoinerLoc() {
		return this.joinerLoc;
	}

	public void setJoinerLoc(String joinerLoc) {
		this.joinerLoc = joinerLoc;
	}

	public String getJoinerLinkname() {
		return this.joinerLinkname;
	}

	public void setJoinerLinkname(String joinerLinkname) {
		this.joinerLinkname = joinerLinkname;
	}

	public String getJoinerPhone() {
		return this.joinerPhone;
	}

	public void setJoinerPhone(String joinerPhone) {
		this.joinerPhone = joinerPhone;
	}

	public String getJoinerEmail() {
		return this.joinerEmail;
	}

	public void setJoinerEmail(String joinerEmail) {
		this.joinerEmail = joinerEmail;
	}

	public String getJoinerAddress() {
		return this.joinerAddress;
	}

	public void setJoinerAddress(String joinerAddress) {
		this.joinerAddress = joinerAddress;
	}

	public String getJoinerBank() {
		return this.joinerBank;
	}

	public void setJoinerBank(String joinerBank) {
		this.joinerBank = joinerBank;
	}

	public String getJoinerHolder() {
		return this.joinerHolder;
	}

	public void setJoinerHolder(String joinerHolder) {
		this.joinerHolder = joinerHolder;
	}

	public String getJoinerBanknum() {
		return this.joinerBanknum;
	}

	public void setJoinerBanknum(String joinerBanknum) {
		this.joinerBanknum = joinerBanknum;
	}

	public String getJoinerExplain() {
		return this.joinerExplain;
	}

	public void setJoinerExplain(String joinerExplain) {
		this.joinerExplain = joinerExplain;
	}

	public Integer getJoLevelId() {
		return this.joLevelId;
	}

	public void setJoLevelId(Integer joLevelId) {
		this.joLevelId = joLevelId;
	}

	public Integer getJoHeigherId() {
		return this.joHeigherId;
	}

	public void setJoHeigherId(Integer joHeigherId) {
		this.joHeigherId = joHeigherId;
	}

	public Date getJoinerDate() {
		return this.joinerDate;
	}

	public void setJoinerDate(Date joinerDate) {
		this.joinerDate = joinerDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getJoinerStatus() {
		return this.joinerStatus;
	}

	public void setJoinerStatus(String joinerStatus) {
		this.joinerStatus = joinerStatus;
	}

	public String getJoinerRemark() {
		return joinerRemark;
	}

	public void setJoinerRemark(String joinerRemark) {
		this.joinerRemark = joinerRemark;
	}

	@Override
	public String toString() {
		return "Joiner{" +
				"joinerId=" + joinerId +
				", joinerName='" + joinerName + '\'' +
				", organId=" +
				", joinerLoc='" + joinerLoc + '\'' +
				", joinerLinkname='" + joinerLinkname + '\'' +
				", joinerPhone='" + joinerPhone + '\'' +
				", joinerEmail='" + joinerEmail + '\'' +
				", joinerAddress='" + joinerAddress + '\'' +
				", joinerBank='" + joinerBank + '\'' +
				", joinerHolder='" + joinerHolder + '\'' +
				", joinerBanknum='" + joinerBanknum + '\'' +
				", joinerExplain='" + joinerExplain + '\'' +
				", joLevelId=" + joLevelId +
				", joHeigherId=" + joHeigherId +
				", joinerDate=" + joinerDate +
				", userId=" + userId +
				", joinerStatus='" + joinerStatus + '\'' +
				", joinerRemark='" + joinerRemark + '\'' +
				'}';
	}
}