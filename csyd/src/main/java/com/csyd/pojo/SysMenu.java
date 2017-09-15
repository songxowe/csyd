package com.csyd.pojo;

public class SysMenu implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer menuParentId;
	private Integer seq;
	private String menuName;
	private String menuDescn;
	private String menuLinkUrl;
	private String menuStatus;

	public SysMenu() {
	}

	@Override
	public String toString() {
		return "SysMenu{" +
				"menuId=" + menuId +
				", menuParentId=" + menuParentId +
				", seq=" + seq +
				", menuName='" + menuName + '\'' +
				", menuDescn='" + menuDescn + '\'' +
				", menuLinkUrl='" + menuLinkUrl + '\'' +
				", menuStatus='" + menuStatus + '\'' +
				'}';
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuParentId() {
		return this.menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescn() {
		return this.menuDescn;
	}

	public void setMenuDescn(String menuDescn) {
		this.menuDescn = menuDescn;
	}

	public String getMenuLinkUrl() {
		return this.menuLinkUrl;
	}

	public void setMenuLinkUrl(String menuLinkUrl) {
		this.menuLinkUrl = menuLinkUrl;
	}

	public String getMenuStatus() {
		return this.menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

}