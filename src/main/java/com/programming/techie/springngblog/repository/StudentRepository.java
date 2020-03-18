package com.programming.techie.springngblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.techie.springngblog.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByFiliere(String filiere);
	public List<Student> findByClasse(String classe);

}
