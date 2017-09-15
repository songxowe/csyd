package com.csyd.pojo;

import java.io.Serializable;

public class SysMenuRole implements Serializable{

	@Override
	public String toString() {
		return "SysMenuRole [menuId=" + menuId + ", roleId=" + roleId + "]";
	}
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer roleId;
	
	
	public SysMenuRole() {
		
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	

}
