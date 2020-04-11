package com.itlize.Project1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.Query;
import com.itlize.Project1.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
    public User get(String uname, String pass) {
        User res=null;
        try{
            Session session=factory.openSession();
        
            String sql="FROM User u where u.uname=:inp_uname and u.pass=:inp_pwd";
            Query query=session.createQuery(sql);
            query.setParameter("inp_uname", uname);
            query.setParameter("inp_pwd", pass);
            res=(User)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

	@Override
    public User get(String uname) {
        User res=null;
        try{
            Session session=factory.openSession();
  
            String sql="FROM User u where u.uname=:inp_uname";
            Query query=session.createQuery(sql);
            query.setParameter("inp_uname", uname);
            res=(User)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

	@Override
    // add user, return is execute condition
    public boolean add(String uname,String pass) {
        try{
            Session session=factory.openSession();
            Transaction tx=session.beginTransaction();
            session.save(new User(uname, pass));
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

