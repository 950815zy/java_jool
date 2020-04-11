package com.itlize.Project1.dao;

import java.util.List;

import com.itlize.Project1.pojo.ProjectList;
import com.itlize.Project1.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ProjectList
 */
@Repository
public class ProjectListDAOImpl implements ProjectListDAO{
//    public static void main(String[] args) {
//        System.out.println(getAll().toString());
//    }
    
    @Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
    public List<ProjectList> getAll(){
		
		Session session=factory.openSession();
        List<ProjectList> res=session.createQuery("FROM ProjectList").getResultList();
        return res;
    }

	@Override
	public ProjectList get(String name) {
		ProjectList res=null;
        Session session=factory.openSession();
    
        String sql="FROM ProjectList WHERE project_name=:name";
        Query query=session.createQuery(sql);
        query.setParameter("name", name);
        res=(ProjectList)query.uniqueResult();
	    return res;
	}

	@Override
    public Integer add(ProjectList proj){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Integer res=(Integer)session.save(proj);
        tx.commit();
        return res;
    }
    
	@Override
    public Integer add(String name){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Integer res=(Integer)session.save(new ProjectList(name));
        tx.commit();
        return res;
    }

	@Override
    public void update(ProjectList proj){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.update(proj);
        tx.commit();
    }

	@Override
    public void delete(String pname){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Query qry=session.createQuery("DELETE FROM ProjectList p where p.project_name=:name");
        qry.setParameter("name", pname);
        qry.executeUpdate();
        tx.commit();
    }
}



