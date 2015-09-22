package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;

public interface ProjectDao {
	  
	public int saveOrUpdate(Project project);
	     
	public int delete(int projectId);
	     
	public Project get(int projectId);
	     
	public List<Project> list();
	
	public List getAllAssociatedUsers(int projectId);
}
