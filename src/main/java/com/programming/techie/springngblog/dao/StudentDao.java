package com.programming.techie.springngblog.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programming.techie.springngblog.model.Student;


@Repository
public interface StudentDao extends CrudRepository<Student, Long>{
	
	List<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

}
