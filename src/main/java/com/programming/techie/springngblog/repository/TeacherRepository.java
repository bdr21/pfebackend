package com.programming.techie.springngblog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.techie.springngblog.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	public List<Teacher> findByFiliere(String filiere) ;
}
