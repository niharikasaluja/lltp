package org.ignou.lltp.controllers;

import java.util.Map;

import org.ignou.lltp.entities.User;
import org.ignou.lltp.repository.UserRepository;
import org.ignou.lltp.service.ProjectService;
import org.ignou.lltp.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private ProjectService projService;
	
	@Autowired
	private UserRepository usrRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<User> helloWorld(){		
		Iterable<User> users = userService.getAllUsers();
		return users;
		
	}
	
	@RequestMapping(value="/userById", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@RequestParam int id){		
		User user = userService.getUserById(id);
		return user;
		
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public @ResponseBody Iterable<User> createUser(@RequestBody User user){		
		
		usrRepository.save(user);
		return usrRepository.findAll();
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestParam Map<String, String> params){		
		System.out.println(params);
		
		return null;
		
	}
	
	@RequestMapping(value="/count", method = RequestMethod.GET)
	public @ResponseBody String getTotalUser(){		
		int usercount = userService.countUsers();
		int projCount = projService.countProjects();
		return "{\"usercount\" : "+usercount+", \"projCount\" : "+projCount+"}";
		
	}
	
	@RequestMapping(value="/isLoggedIn", method = RequestMethod.GET)
	public @ResponseBody org.springframework.security.core.userdetails.User isLoggedin(){		
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String name = user.getUsername(); //get logged in username
			return user;
			
	}
	
}
