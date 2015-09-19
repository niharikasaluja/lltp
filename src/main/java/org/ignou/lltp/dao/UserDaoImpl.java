package org.ignou.lltp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.ignou.lltp.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	 
	public UserDaoImpl(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int contactId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM user";
		    List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {
		 
		        @Override
		        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	User user = new User();
		 
		            user.setId(rs.getInt("id"));
		            user.setUserName(rs.getString("userName"));
		            user.setEmail(rs.getString("email"));	
		            return user;
		        }
		 
		    });
		 
		    return listContact;
		
	}

}
