package com.itlize.Project1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itlize.Project1.pojo.User;
import com.itlize.Project1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public User logIn(@RequestBody User user){
		System.out.println("login request..."+user.toString());
		userService.verification(user.getUname(),user.getPass());
		return user;
	}
	
	@PostMapping("/signup")
	public User signUp(@RequestBody User user){
		userService.signUp(user);
		return user;
	}
	
	@PostMapping("/profile")
	public String display(@RequestBody String uname){
		System.out.println(uname);
		User res=userService.getbyUser(uname);
		if(res!=null)
		{
			System.out.println(res.toString());
			return res.toString();
		}else{
			System.out.println("no result..");
			return "no such user found...";
		}
	}
}

