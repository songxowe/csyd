package com.csyd.pojo;


public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String organId;
	private String job;
	private String name;
	private String sex;
	private String phone;
	private String docType;
	private String docNumber;
	private String agentName;
	private String loc;
	private String bankName;
	private String bankNumber;
	private Integer userId;

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", organId='" + organId + '\'' +
				", job='" + job + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", docType='" + docType + '\'' +
				", docNumber='" + docNumber + '\'' +
				", agentName='" + agentName + '\'' +
				", loc='" + loc + '\'' +
				", bankName='" + bankName + '\'' +
				", bankNumber='" + bankNumber + '\'' +
				", userId=" + userId +
				'}';
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return this.docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return this.bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}