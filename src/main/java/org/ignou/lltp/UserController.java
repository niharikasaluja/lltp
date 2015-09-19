package org.ignou.lltp;

import java.util.List;

import org.ignou.lltp.entities.User;
import org.ignou.lltp.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<User> helloWorld(){		
		Iterable<User> users = userService.getAllUsers();
		return users;
		
	}
	
}