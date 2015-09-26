package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;

public interface TaskDao {
	public int saveOrUpdate(Task task);
    
	public int delete(int taskId);
	     
	public Task get(int taskId);
	
	public int countTasks();

	public List<Task> list();
	
	public Task getAssociatedUser(int taskId);
}
