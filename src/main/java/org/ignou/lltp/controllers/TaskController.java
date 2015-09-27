package org.ignou.lltp.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;
import org.ignou.lltp.entities.User;
import org.ignou.lltp.repository.ProjectRepository;
import org.ignou.lltp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	String pattern = "dd-MMM-yyyy";
	SimpleDateFormat format = new SimpleDateFormat(pattern);

	@RequestMapping(value = "/allTasksForProject", method = RequestMethod.GET)
	public @ResponseBody List<Task> getAllTasks(@RequestParam String projectId) {
		Project project = projectRepository.findOne(Long.parseLong(projectId));
		
		return taskRepository.findAllByProject(project);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public @ResponseBody String getTotalUser(@RequestBody Project proj) {
		long count = taskRepository.count();
		return "{\"taskcount\" : " + count + "}";

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Iterable<Task> create(HttpServletRequest request, @RequestBody Task task, @RequestParam String projId ) {
		System.out.println(task);
		User user = (User) request.getSession().getAttribute("user");
		task.setUser(user);
		Project project = projectRepository.findOne(Long.parseLong(projId));
		task.setProject(project);
		taskRepository.save(task);
		return taskRepository.findAllByProject(project);

	}
	
	@RequestMapping(value = "/updateTaskStatus", method = RequestMethod.GET)
	public @ResponseBody String updateTaskStatus(@RequestParam String taskId,@RequestParam String status) {
		Task task = taskRepository.findOne(Long.parseLong(taskId));
		task.setStatus(status);
		return "success";
	}
	
	@RequestMapping(value = "/getTaskDetails", method = RequestMethod.GET)
	public @ResponseBody Task getTaskDetails(@RequestParam String taskId) {
		Task task = taskRepository.findOne(Long.parseLong(taskId));
		return task;
	}

}
