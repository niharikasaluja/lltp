package org.ignou.lltp.service;

import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectService {
	
	public String helloUser(String uname){
		
		return "Hello "+uname;
	}
	
	
}
