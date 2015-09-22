package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.User;

public interface ProjectDao {
	  
	public void saveOrUpdate(Project project);
	     
	public void delete(int projectId);
	     
	public User get(int projectId);
	     
	public List<Project> list();
}
