package org.ignou.lltp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.ignou.lltp.entities.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public UserDaoImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveOrUpdate(User user) {
		
		String query="insert into employee values('"+user.getId()+"','"+user.getUserName()+"','"+user.getEmail()+"')";  
		return jdbcTemplate.update(query);  
	}

	@Override
	public int delete(int userId) {
		
		String query="delete from user where id='"+ userId +"' ";  
	    return jdbcTemplate.update(query); 
	}

	@Override
	public User get(int userId) {
		 String sql = "SELECT * FROM user where id =" + userId;

		 User user = jdbcTemplate.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper(User.class));
		 
		 /*User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			 
		        @Override
		        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	User user = new User();
		 
		            user.setId(rs.getInt("id"));
		            user.setUserName(rs.getString("userName"));
		            user.setEmail(rs.getString("email"));	
		            user.setRole(rs.getString("role"));	
		            return user;
		        }
		 
		    });*/
		/* {
			 
		        @Override
		        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	User user = new User();
		 
		            user.setId(rs.getInt("id"));
		            user.setUserName(rs.getString("userName"));
		            user.setEmail(rs.getString("email"));	
		            user.setRole(rs.getString("role"));	
		            return user;
		        }
		 
		    });*/
		 
		    return user;
	}

	@Override
	public List<User> listOfUsers() {

		String sql = "SELECT * FROM user";

		List<User> users  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));

		/*List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));	
				user.setRole(rs.getString("role"));	
				return user;
			}

		});*/

		return users;

	}

	@Override
	public int countUsers() {
		
		String sql="Select Count(*) from user";
		Integer count= jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	@Override
	public int createUser(User user){
		
		String query= "insert into user values('"+user.getId()+"','"+user.getUserName()+"','"+user.getEmail()+"')";  
		return jdbcTemplate.update(query);  
		
	}
}
