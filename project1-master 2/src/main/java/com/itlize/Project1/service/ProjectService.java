package com.itlize.Project1.service;

import java.util.List;

import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ProjectList;
import com.itlize.Project1.pojo.newResourceTable;

public interface ProjectService {
	
	public List<ProjectList> displayAllProjects();
	
	public void saveProject(ProjectList theProject);
	
	public ProjectList getProject(String pname);
	
	public void deleteProject(String pname);
	
}
