package org.ignou.lltp.service;

import java.util.List;

import org.ignou.lltp.dao.UserDao;
import org.ignou.lltp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServices {
	
	 @Autowired
	 private UserDao userDAO;
	
	public List<User> getAllUsers(){
		
		return userDAO.listOfUsers();
	}
	
	public User getUserById(int userId){
		
		return userDAO.get(userId);
	}
	
	
}
