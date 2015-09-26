package org.ignou.lltp.controllers;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.repository.ProjectRepository;
import org.ignou.lltp.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
@RequestMapping("projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	
	@Autowired
	private ProjectRepository projRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Project> getAllProjects(){		
		System.out.println(projRepository.findAll());
		Iterable<Project> projects = projectService.getAllProjects();
		return projRepository.findAll();
		
	}
	
	
	@RequestMapping(value="/count", method = RequestMethod.GET)
	public @ResponseBody String getTotalUser(){		
		int count = projectService.countProjects();
		return "{\"usercount\" : "+count+"}";
		
	}
	
}
