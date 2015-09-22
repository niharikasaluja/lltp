package org.ignou.lltp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProjectDaoImpl implements ProjectDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public ProjectDaoImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int ProjectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> list() {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM project";
		    List<Project> listContact = jdbcTemplate.query(sql, new RowMapper<Project>() {
		 
		        @Override
		        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Project project = new Project();
		 
		        	project.setId(rs.getInt("id"));
		        	project.setName(rs.getString("projectName"));
		            
		            return project;
		        }
		 
		    });
		 
		    return listContact;
		
	}

}
