package com.itlize.Project1.dao;
import java.util.List;
import org.springframework.core.io.Resource;

import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ResourcePool;
import com.itlize.Project1.pojo.newResourceTable;
import com.itlize.Project1.pojo.WholeTable;
public interface ResourcePoolDAO {
	
	// display all resources
	public List<ResourcePool> getAllResource();
	
	// search a resource by name
	public ResourcePool getResourceByName(String cost_code);
	
	// add a new resource
	public ResourcePool addRow(ResourcePool resource);
	
	// delete an existing resource
	public void delete(ResourcePool resource);
	
	// update an existing resource
	public void update(ResourcePool resource);
	
	// import an csv file
	public List<ResourcePool> addCSVResource(List <ResourcePool> list);
	
	public List<newResourceTable> getNewTable();
	
	public NewColumnName addColumn(NewColumnName name);
	
	public NewColumnValue addColValue(NewColumnValue value);

	//public List<WholeTable> getWholeTable();

	// display all resources depends on project
	public List<ResourcePool> getResourceByProjectId(Integer pid);
}


