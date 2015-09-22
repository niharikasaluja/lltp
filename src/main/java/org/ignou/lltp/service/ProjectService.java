package org.ignou.lltp.service;

import org.ignou.lltp.dao.ProjectDao;
import org.ignou.lltp.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectService {
	
	@Autowired
	 private ProjectDao projectDAO;
	
	public Iterable<Project> getAllProjects(){
		
		return projectDAO.list();
	}
	
	public int countProjects()
	{
		return projectDAO.countProjects();
	}
}
	

