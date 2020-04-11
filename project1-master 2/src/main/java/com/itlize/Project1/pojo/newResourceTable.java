package com.itlize.Project1.pojo;

import java.util.HashMap;
import java.util.Map;

public class newResourceTable {
	
	String name;
	String cost_code;
	String column_name;
	String column_value;
	//Map<String, String> additional_properties = new HashMap<String, String>();
	

	
	public String getName() {
		return name;
	}
	public newResourceTable(String name, String cost_code, String column_name,
			String column_value) {
		super();
		this.name = name;
		this.cost_code = cost_code;
		this.column_name = column_name;
		this.column_value = column_value;
	}
	public String getCost_code() {
		return cost_code;
	}
	public void setCost_code(String cost_code) {
		this.cost_code = cost_code;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_value() {
		return column_value;
	}
	public void setColumn_value(String column_value) {
		this.column_value = column_value;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
