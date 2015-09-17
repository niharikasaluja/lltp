package org.ignou.lltp.repository;

import org.ignou.lltp.entities.Project;
import org.springframework.data.repository.CrudRepository;


public interface ProjectRepository extends CrudRepository<Project, Long> {
}