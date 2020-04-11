package com.itlize.Project1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ResourcePool;
import com.itlize.Project1.pojo.WholeTable;
import com.itlize.Project1.pojo.newResourceTable;
import com.itlize.Project1.service.ResourceService1; 
@RestController
@CrossOrigin
@RequestMapping("/res")
public class ResouceController {
	@Autowired
	private ResourceService1 resourceService;
	
	@PostMapping(value = "/addRow")
	public ResourcePool addRow(@RequestBody ResourcePool resource) throws Exception {

		resourceService.addResourceRow(resource);
		return resource;
	}
	
	@RequestMapping(value = "/addCSV", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List <ResourcePool> addCSVResource(@RequestBody List <ResourcePool> re) throws Exception {
			return resourceService.addCSVResource(re);
	
	}
	
	@RequestMapping(value = "/displayResources", method = RequestMethod.GET)
	public List <ResourcePool> getAllResource () throws Exception {
			return resourceService.displayAllResource();

	}
	
//	@GetMapping("/displayWhole")
//	public List<WholeTable> getWholeTable(){
//		return resourceService.displayWholeTable();
//	}
	
	@GetMapping("/displayNewTable")
	public List<newResourceTable> getNewTable() {
		return resourceService.getNewTable();
	}
	
	@PostMapping(value = "addColumnName")
	public NewColumnName addColumnName(@RequestBody NewColumnName name) {
			resourceService.addColumn(name);
			return name;
	}
	
	@PostMapping(value = "addColumnValue")
	public NewColumnValue addColumnValue(@RequestBody NewColumnValue value) {
			resourceService.addColValue(value);
			return value;
	}

	@RequestMapping(value = "/displayByProjectId/{pid}", method = RequestMethod.GET)
	public List<ResourcePool> displayByPorject(@PathVariable Integer pid) throws Exception{
		try {
			return resourceService.displayResourceByProject(pid);
		}
		catch(Exception e) {
			throw e;
		}
	}
}