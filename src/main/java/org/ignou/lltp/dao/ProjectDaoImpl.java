package org.ignou.lltp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProjectDaoImpl implements ProjectDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public ProjectDaoImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveOrUpdate(Project project) {
		String query="insert into project values('"+project.getId()+"','"+project.getName()+"','"+project.getCreationDate()+"')";  
		return jdbcTemplate.update(query);  
		
	}

	@Override
	public int delete(int projectId) {
		String query="delete from project where id='"+ projectId +"' ";  
	    return jdbcTemplate.update(query);
		
	}

	@Override
	public Project get(int projectId) {
		
		String sql = "SELECT * FROM Project where id =" + projectId;

		Project project = jdbcTemplate.queryForObject(sql, new Object[] { projectId }, new BeanPropertyRowMapper(Project.class));
		return project;
	}

	@Override
	public List<Project> list() {
		
		 String sql = "SELECT * FROM project";
		 List<Project> projects  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(Project.class));
		 
		   /* List<Project> listContact = jdbcTemplate.query(sql, new RowMapper<Project>() {
		 
		        @Override
		        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Project project = new Project();
		 
		        	project.setId(rs.getInt("id"));
		        	project.setName(rs.getString("projectName"));
		            
		            return project;
		        }
		 
		    });*/
		 
		    return projects;
		
	}

	public List getAllAssociatedUsers(int projectId){
		
		String sql = "SELECT * FROM Project where id =" + projectId;
		Project project = jdbcTemplate.queryForObject(sql, new Object[] { projectId }, new BeanPropertyRowMapper(Project.class));
		return (List) project.getUsers();
	}

	@Override
	public int countProjects() {
		// TODO Auto-generated method stub
			String sql="Select Count(*) from project";
			Integer count= jdbcTemplate.queryForInt(sql);
			return count;
		
		
	}

	@Override
	public List listTasks(int projectId) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM Project where id =" + projectId;
		Project project = jdbcTemplate.queryForObject(sql, new Object[] { projectId }, new BeanPropertyRowMapper(Project.class));
		return (List) project.getTasks();
		
	}
	
}
