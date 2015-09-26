package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;

public interface ProjectDao {
	  
	public int saveOrUpdate(Project project);
	     
	public int delete(int projectId);
	     
	public Project get(int projectId);
	
	public int countProjects();

	public List<Project> list();
	
	public List listTasks(int projectId);
	
	public List getAllAssociatedUsers(int projectId);
}
