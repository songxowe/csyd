package com.csyd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EchartsData implements  Serializable{

	private static final long serialVersionUID = 1L;
	List<String> category=new ArrayList<String>();
	List<Integer> y=new ArrayList<Integer>();
	
	
	public EchartsData() {
		
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<Integer> getY() {
		return y;
	}
	public void setY(List<Integer> y) {
		this.y = y;
	}
	

}
