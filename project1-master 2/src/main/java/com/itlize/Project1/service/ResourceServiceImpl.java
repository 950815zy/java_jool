
package com.itlize.Project1.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itlize.Project1.dao.ResourcePoolDAO;
import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ResourcePool;
import com.itlize.Project1.pojo.WholeTable;
import com.itlize.Project1.pojo.newResourceTable;
import com.itlize.Project1.service.ResourceService1;
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService1 {
	
	@Autowired
	private ResourcePoolDAO resourcePoolDAO;
	@Override
	public List<ResourcePool> displayAllResource() {
		
		return resourcePoolDAO.getAllResource();
	}
	
	@Override
	public ResourcePool addResourceRow(ResourcePool resource) {
		resourcePoolDAO.addRow(new ResourcePool(resource.getCost_code(),resource.getName()));
		return resource;
	}
	
//	@Override
//	public List<WholeTable> displayWholeTable() {
//		return resourcePoolDAO.getWholeTable();
//	}
	
	@Override
	public List<ResourcePool> addCSVResource(List<ResourcePool> list) {
		return resourcePoolDAO.addCSVResource(list);
	}
	
	@Override
	public NewColumnName addColumn(NewColumnName name) {
		return resourcePoolDAO.addColumn(new NewColumnName(name.getColumn_name()));
	}
	
	@Override
	public NewColumnValue addColValue(NewColumnValue value) {
		//need modified
		return resourcePoolDAO.addColValue(value);
	}
	
	
	@Override
	public List<newResourceTable> getNewTable() {
		return resourcePoolDAO.getNewTable();
	}

	
	@Override
	public List<ResourcePool> displayResourceByProject(Integer pid) {
		
		return resourcePoolDAO.getResourceByProjectId(pid);
	}

}