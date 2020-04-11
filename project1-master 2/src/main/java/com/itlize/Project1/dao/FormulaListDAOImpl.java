package com.itlize.Project1.dao;

import java.util.List;

import com.itlize.Project1.pojo.FormulaList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * FormulaList
 */
@Repository
public class FormulaListDAOImpl implements FormulaListDAO{

	@Autowired
	private SessionFactory factory;
	
    @SuppressWarnings("unchecked")
    @Override
    public List<FormulaList> getAll(){
        Session session=factory.openSession();
        String sql = "FROM FormulaList";
        List<FormulaList> res=session.createQuery(sql).getResultList();
        return res;
    }

    @Override
    public FormulaList get(String name){
    	FormulaList res = null;
        Session session=factory.openSession();
        String sql="FROM FormulaList WHERE project_name=:name";
        Query query=session.createQuery(sql);
        query.setParameter("name", name);
        res=(FormulaList)query.uniqueResult();
        return res;
    }

    @Override
    public Integer add(FormulaList proj){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Integer res=(Integer)session.save(proj);
        tx.commit();
        return res;
    }

    @Override
    public void update(FormulaList proj){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.update(proj);
        tx.commit();
    }

    @Override
    public void delete(FormulaList proj){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.delete(proj);
        tx.commit();
    }
}