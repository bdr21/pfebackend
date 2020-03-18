package com.programming.techie.springngblog.service;

import java.util.List;
import java.util.Optional;

import com.programming.techie.springngblog.model.Student;


public interface StudentService {
	
	List<Student> findAllStudents();
	
	Optional<Student>  findStudentById(Long id) ;
	
    Student save(Student student);

	void deleteStudent(Long id);

	List<Student> findStudentsByFiliere(String filiere);
	
	List<Student> findStudentsByClasse(String classe);

}
