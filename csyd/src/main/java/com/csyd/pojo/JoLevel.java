package com.csyd.pojo;

public class JoLevel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer joLevelId;
	private String joLevelName;
	private String joLevelExplain;

	public JoLevel() {
	}

	public Integer getJoLevelId() {
		return this.joLevelId;
	}

	public void setJoLevelId(Integer joLevelId) {
		this.joLevelId = joLevelId;
	}

	public String getJoLevelName() {
		return this.joLevelName;
	}

	public void setJoLevelName(String joLevelName) {
		this.joLevelName = joLevelName;
	}

	public String getJoLevelExplain() {
		return this.joLevelExplain;
	}

	public void setJoLevelExplain(String joLevelExplain) {
		this.joLevelExplain = joLevelExplain;
	}

}