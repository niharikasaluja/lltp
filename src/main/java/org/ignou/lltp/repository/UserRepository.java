package org.ignou.lltp.repository;

import org.ignou.lltp.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUserName(String userName);
}