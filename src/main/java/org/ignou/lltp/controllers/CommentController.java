package org.ignou.lltp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.ignou.lltp.entities.Comment;
import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;
import org.ignou.lltp.entities.User;
import org.ignou.lltp.repository.CommentRepository;
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
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public @ResponseBody Iterable<Project> home(@RequestBody Comment comment, @RequestParam String taskId,  HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		comment.setUser(user);
		Task task = taskRepository.findOne(Long.parseLong(taskId));
		comment.setTask(task);
		repository.save(comment);
		return null;
	}
	

	
}
