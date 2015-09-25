package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.User;

public interface UserDao {
	  public void saveOrUpdate(User user);
	     
	    public void delete(int contactId);
	     
	    public User get(int userId);
	     
	    public List<User> list();
}
