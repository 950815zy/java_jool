package com.itlize.Project1.service;

import java.util.List;

import javax.transaction.Transactional;
import com.itlize.Project1.dao.ProjectListDAO;
import com.itlize.Project1.dao.UserDAO;
import com.itlize.Project1.pojo.ProjectList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService{	

	@Autowired
	ProjectListDAO projectListDAO;

	
	@Override
	public List<ProjectList> displayAllProjects() {
		
		return projectListDAO.getAll();
	}

	@Override
	public void saveProject(ProjectList theProject) {
		
		projectListDAO.add(theProject);
	}

	@Override
	public ProjectList getProject(String pname) {
		
		return projectListDAO.get(pname);
	}

	@Override
	public void deleteProject(String pname) {
		projectListDAO.delete(pname);
	}

}