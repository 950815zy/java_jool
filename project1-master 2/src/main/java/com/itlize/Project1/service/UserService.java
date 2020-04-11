package com.itlize.Project1.service;

import com.itlize.Project1.pojo.User;

public interface UserService {
	
	public User getbyUser(String uname);
	
	public User verification(String uname, String pass);
	
	public User signUp(User u);
}
