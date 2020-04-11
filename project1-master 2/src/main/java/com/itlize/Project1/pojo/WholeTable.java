package com.itlize.Project1.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

public class WholeTable {

	String name;
	String cost_code;

	Map<String, String> columns;
	// Map<String, String> additional_properties = new HashMap<String, String>();

	public String getName() {
		return name;
	}

	public WholeTable(String name, String cost_code, Map<String, String> columns) {
		super();
		this.name = name;
		this.cost_code = cost_code;
		this.columns = columns;
	}

	public WholeTable(String name, String cost_code) {
		super();
		this.name = name;
		this.cost_code = cost_code;
	}
	public String getCost_code() {
		return cost_code;
	}
	public void setCost_code(String cost_code) {
		this.cost_code = cost_code;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "wholeTable [columns=" + columns + ", cost_code=" + cost_code + ", name=" + name + "]";
	}

	public Map<String, String> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, String> columns) {
		this.columns = columns;
	}
	
}