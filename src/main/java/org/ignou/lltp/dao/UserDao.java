package org.ignou.lltp.dao;

import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.User;

public interface UserDao {

	public int saveOrUpdate(User user);

	public int delete(int contactId);

	public User get(int userId);

	public List<User> listOfUsers();

	public int countUsers();

	public int createUser(User user);

}
