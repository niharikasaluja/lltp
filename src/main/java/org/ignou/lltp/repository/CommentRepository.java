package org.ignou.lltp.repository;

import org.ignou.lltp.entities.Comment;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}