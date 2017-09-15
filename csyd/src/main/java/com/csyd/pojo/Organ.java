package com.csyd.pojo;

public class Organ implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer organId;
	private String organHeigh;
	private String organName;
	private String organType;
	private String organLoc;
	private String organDir;
	private String organLinkman;
	private String organPhone;
	private String organExplain;

	public Organ() {
	}

	public Integer getOrganId() {
		return this.organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public String getOrganHeigh() {
		return this.organHeigh;
	}

	public void setOrganHeigh(String organHeigh) {
		this.organHeigh = organHeigh;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganType() {
		return this.organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getOrganLoc() {
		return this.organLoc;
	}

	public void setOrganLoc(String organLoc) {
		this.organLoc = organLoc;
	}

	public String getOrganDir() {
		return this.organDir;
	}

	public void setOrganDir(String organDir) {
		this.organDir = organDir;
	}

	public String getOrganLinkman() {
		return this.organLinkman;
	}

	public void setOrganLinkman(String organLinkman) {
		this.organLinkman = organLinkman;
	}

	public String getOrganPhone() {
		return this.organPhone;
	}

	public void setOrganPhone(String organPhone) {
		this.organPhone = organPhone;
	}

	public String getOrganExplain() {
		return this.organExplain;
	}

	public void setOrganExplain(String organExplain) {
		this.organExplain = organExplain;
	}

}