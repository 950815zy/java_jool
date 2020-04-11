package com.itlize.Project1.service;

import java.util.List;
import java.io.*;
import java.util.Date;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;

// import org.hibernate.Session;
// import org.hibernate.annotations.GenericGenerator;
// import org.omg.CORBA.PUBLIC_MEMBER;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;
// import org.apache.log4j.Logger;
// import com.sun.xml.internal.bind.v2.runtime.Name;
// import sun.security.util.Password;

import com.itlize.Project1.dao.UserDAO;
import com.itlize.Project1.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.Exception;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Qualifier("userService")
	
	@Override
	public User getbyUser(String uname) {
		return userDAO.get(uname);
	}
	
	@Override
	public User verification(String uname, String pass) {
        if(userDAO.get(uname) != null && userDAO.get(uname).getPass().equals(pass)){
            System.out.println("a login accepted..");
		}
		else{
			System.out.println("a login denied..");
		}
		return userDAO.get(uname);
	}
    
	@Override
	public User signUp(User u) {
		if (userDAO.get(u.getUname()) != null) {
			System.out.println("Username exists.");
		}
		else{
			userDAO.add(u.getUname(),u.getPass());
			System.out.println("a new user added..");
		}
		return u;
	}
}