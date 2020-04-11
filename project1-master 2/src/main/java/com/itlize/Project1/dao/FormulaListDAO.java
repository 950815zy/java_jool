package com.itlize.Project1.dao;

import java.util.List;

import com.itlize.Project1.pojo.FormulaList;

public interface FormulaListDAO {
	
	public List<FormulaList> getAll();
	
	public FormulaList get(String name);
	
	public Integer add(FormulaList proj);
	
	public void update(FormulaList proj);
	
	public void delete(FormulaList proj);
}
