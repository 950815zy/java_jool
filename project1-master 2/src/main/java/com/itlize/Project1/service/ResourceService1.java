package com.itlize.Project1.service;
import java.util.List;

import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ResourcePool;
import com.itlize.Project1.pojo.WholeTable;
import com.itlize.Project1.pojo.newResourceTable;
public interface ResourceService1 {
	
	// display all resource
	public List<ResourcePool> displayAllResource();
	
	// add new row
	public ResourcePool addResourceRow(ResourcePool resource);
	
	// display all table
	//public List<WholeTable> displayWholeTable();
	
	// add csv file
	public List <ResourcePool> addCSVResource(List <ResourcePool> list);
	
	public List<newResourceTable> getNewTable();
	
	public NewColumnName addColumn(NewColumnName name);
	
	public NewColumnValue addColValue(NewColumnValue value);
	
	// display resources by project
	public List<ResourcePool> displayResourceByProject(Integer pid);
	
}