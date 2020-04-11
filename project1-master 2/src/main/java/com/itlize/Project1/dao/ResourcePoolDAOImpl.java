package com.itlize.Project1.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
import org.springframework.stereotype.Repository;

import com.itlize.Project1.dao.ResourcePoolDAO;
import com.itlize.Project1.pojo.NewColumnName;
import com.itlize.Project1.pojo.NewColumnValue;
import com.itlize.Project1.pojo.ResourcePool;
import com.itlize.Project1.pojo.User;
import com.itlize.Project1.pojo.newResourceTable;
import com.itlize.Project1.pojo.WholeTable;
@Repository
public class ResourcePoolDAOImpl implements ResourcePoolDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResourcePool> getAllResource() {	
		// start a new session
		Session currentSession = sessionFactory.getCurrentSession();	
		// start new query and get result
		String sql = "from ResourcePool";
		List<ResourcePool> res = currentSession.createQuery(sql).list();	
		currentSession.flush();		
		return res;
	}
	
	@Override
	public ResourcePool getResourceByName(String cost_code) {
		
		// start a new session
		Session currentSession = sessionFactory.getCurrentSession();	
		Transaction tx = currentSession.beginTransaction();		
		ResourcePool res = (ResourcePool)currentSession.get("ResourcePool", cost_code);	
		currentSession.flush();	
		return res;
		
	}
	@Override
	public ResourcePool addRow(ResourcePool resource) {
		
		// start a new session
		Session currentSession = sessionFactory.getCurrentSession();
		String id = (String) currentSession.save(resource);		
		currentSession.flush();		
		return resource;
	}
	
	@Override
	public void delete(ResourcePool resource) {		
		// start a new session
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.delete(resource);		
		currentSession.flush();
	}
	@Override
	public void update(ResourcePool resource) {
		
		// start a new session
		Session currentSession = sessionFactory.getCurrentSession();	
		currentSession.update(resource);
		
		currentSession.flush();
	}
	
	
	@Override
	public List<ResourcePool> addCSVResource(List<ResourcePool> list) {
		try {
			// start a new session
			Session currentSession = sessionFactory.getCurrentSession();		
			for(ResourcePool resource : list) {			
				currentSession.save(resource);			
			}	
			currentSession.flush();	
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		return list;
	}
	
	@Override
	public NewColumnName addColumn(NewColumnName name){
	
		Session session = sessionFactory.getCurrentSession();
		session.save(name);
		session.flush();
		return name;

	}
	
	public NewColumnValue addColValue(NewColumnValue value) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(value);
		session.flush();
		return (value);
		
	}
	
	@Override
	public List<newResourceTable> getNewTable() {
		List<newResourceTable> res = null;
        try{
            Session session=sessionFactory.getCurrentSession();
            String sql="select new com.itlize.Project1.pojo.newResourceTable(p.name, p.cost_code, n.column_name, e.column_value) " +
            		"from NewColumnValue e " +
            		"join e.pool p " +
            		"join e.name n";
            Query query=session.createQuery(sql);
            res=query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
	}
	


	
//	@Override
//	public List<WholeTable> getWholeTable(){
//		Session session=sessionFactory.getCurrentSession();
//		List<WholeTable> res = new ArrayList<>();
//
//		for(ResourcePool resource:session.createQuery("FROM ResourcePool",ResourcePool.class)
//			.getResultList()){
//			WholeTable wt=new WholeTable(resource.getName(), resource.getCost_code());
//			wt.setColumns(new HashMap());
//			for(Map col:session
//				.createQuery("SELECT new Map(V.name.column_name,V.column_value) FROM NewColumnValue V WHERE V.pool.cost_code=:code",Map.class)
//				.setParameter("code", wt.getCost_code()).getResultList()){
//				wt.getColumns().putAll(col);
//			}
//			res.add(wt);
//		}
//		
//		return res;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourcePool> getResourceByProjectId(Integer pid) {

		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "from ResourcePool r "
				+ "inner join r.projectId p where p.pid = :id";
		Query query = currentSession.createQuery(hql);
		query.setParameter("id", pid);
		List<ResourcePool> res = query.list();
		currentSession.flush();
		return res;
	}
}