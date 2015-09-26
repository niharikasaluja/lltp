package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TaskDaoImpl implements TaskDao {
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveOrUpdate(Task task) {
		// TODO Auto-generated method stub
		String query="insert into task values('"+task.getId()+"','"+task.getProject()+"','"+task.getCreationDate()+"')";  
		return jdbcTemplate.update(query);
	}

	@Override
	public int delete(int taskId) {
		// TODO Auto-generated method stub
		String query="delete from task where id='"+ taskId +"' ";  
	    return jdbcTemplate.update(query);
	}

	@Override
	public Task get(int taskId) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM Task where id =" + taskId;

		Task task = jdbcTemplate.queryForObject(sql, new Object[] { taskId }, new BeanPropertyRowMapper(Task.class));
		return task;
	}

	@Override
	public int countTasks() {
		// TODO Auto-generated method stub
		String sql="Select Count(*) from task";
		Integer count= jdbcTemplate.queryForInt(sql);
		return count;
	}

	@Override
	public List<Task> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM task";
		 List<Task> task  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(Task.class));
		 
		return task;
	}

	@Override
	public Task getAssociatedUser(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

}
