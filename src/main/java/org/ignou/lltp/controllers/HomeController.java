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
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private ProjectService projectService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public @ResponseBody Iterable<Project> home() {
		return repository.findAll();
	}
	
	/*@RequestMapping(value="/hello", method = RequestMethod.GET)
	public @ResponseBody String helloWorld(){
		
		return projectService.helloUser("Manu");
		
	}*/
	
}
