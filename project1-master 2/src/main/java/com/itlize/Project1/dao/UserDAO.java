package com.itlize.Project1.dao;

import com.itlize.Project1.pojo.User;

public interface UserDAO {
	
	public User get(String uname, String pass);
	
	public User get(String uname);
	
	public boolean add(String uname,String pass);
}
