package org.ignou.lltp.repository;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;
import org.ignou.lltp.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Long> {
	public List<Task> findAllByProject(Project project);
	public List<Task> findAllByUser(User user);
}