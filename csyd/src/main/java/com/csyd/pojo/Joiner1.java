package com.csyd.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Joiner1 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer joinerId;
	private String joinerName;
	private Integer organId;
	private String joinerLoc;
	private String joinerLinkname;
	private String joinerPhone;
	private String joinerEmail;
	private String joinerAddress;
	private String joinerBank;
	private String joinerHolder;
	private String joinerBanknum;
	private String joinerExplain;
	private Integer joLevelId;
	private Integer joHeigherId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joinerDate;
	private Integer userId;
    private String userFlag;
	private String joinerStatus;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	

	public Joiner1() {
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

	public Integer getOrganId() {
		return this.organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
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




	@Override
	public String toString() {
		return "Joiner [joinerId=" + joinerId + ", joinerName=" + joinerName + ", organId=" + organId + ", joinerLoc="
				+ joinerLoc + ", joinerLinkname=" + joinerLinkname + ", joinerPhone=" + joinerPhone + ", joinerEmail="
				+ joinerEmail + ", joinerAddress=" + joinerAddress + ", joinerBank=" + joinerBank + ", joinerHolder="
				+ joinerHolder + ", joinerBanknum=" + joinerBanknum + ", joinerExplain=" + joinerExplain
				+ ", joLevelId=" + joLevelId + ", joHeigherId=" + joHeigherId + ", joinerDate=" + joinerDate
				+ ", userId=" + userId + ", userFlag=" + userFlag + ", joinerStatus=" + joinerStatus + "]";
	}

	public String getJoinerStatus() {
		return this.joinerStatus;
	}

	public void setJoinerStatus(String joinerStatus) {
		this.joinerStatus = joinerStatus;
	}

}