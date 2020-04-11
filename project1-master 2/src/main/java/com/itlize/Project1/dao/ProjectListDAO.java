package com.itlize.Project1.dao;

import java.util.List;

import com.itlize.Project1.pojo.ProjectList;

public interface ProjectListDAO {
	
	public List<ProjectList> getAll();
	
	public ProjectList get(String name);
	
	public Integer add(ProjectList proj);
	
	public Integer add(String name);
	
	public void update(ProjectList proj);
	
	public void delete(String pname);
}
