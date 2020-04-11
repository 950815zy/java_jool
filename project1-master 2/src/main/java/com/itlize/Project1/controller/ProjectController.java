package com.itlize.Project1.controller;
import java.util.List;

import com.itlize.Project1.pojo.ProjectList;
import com.itlize.Project1.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {
	
	// inject the project service
	@Autowired
	private ProjectService projectService;
	
	// display all project in the project table
	@GetMapping("/display")
	public List<ProjectList> displayAllProjects(){
		
		return projectService.displayAllProjects();
	}
	
	// search project based on pid
	@GetMapping("/get/{pname}")
	public ProjectList getProject(@PathVariable String pname) throws Exception {
		System.out.println("get read request...");
		ProjectList theProject = projectService.getProject(pname);
		
		if (theProject == null) {
			throw new Exception("The project id not found - " + pname);
		}
		
		return theProject;
	}
	
	// add new project
	@PostMapping("/add")
	public ProjectList addProject(@RequestBody ProjectList theProject) {
		theProject.setPid(0);
		projectService.saveProject(theProject);
		
		return theProject;
	}
	

	// update a existing project
	@PostMapping("/update")
	public ProjectList updateProject(@RequestBody String oldname,@RequestBody ProjectList theProject) {
		ProjectList inp=theProject;
		ProjectList oldone=projectService.getProject(oldname);
		if(oldone!=null){
			inp.setPid(oldone.getPid());
			projectService.saveProject(theProject);
		}
		return theProject;
	}
	
	// delete a existing project
	@DeleteMapping("/delete/{pname}")
	public String deleteProject(@PathVariable String pname) throws Exception{
		
		ProjectList theProject = projectService.getProject(pname);
		
		if (theProject == null) {
			throw new Exception("The project name not found - " + pname);
		}
		
		projectService.deleteProject(pname);
		return "Project: " + pname + " Deleted!";
	}
}
