package com.programming.techie.springngblog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.springngblog.dao.StudentDao;
import com.programming.techie.springngblog.model.Student;
import com.programming.techie.springngblog.model.Teacher;
import com.programming.techie.springngblog.repository.StudentRepository;
import com.programming.techie.springngblog.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired private StudentDao studentDao;
	@Autowired private StudentRepository studentRepository ;
	
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public Student save(Student student) {
        return studentDao.save(student);
    }

	public void deleteStudent(Long id) {
		studentDao.deleteById(id);
	}

	public Optional<Student> findStudentById(Long id) {
		return studentDao.findById(id);
	}

	
	public List<Student> findStudentsByFiliere(String filiere) {
		List<Student> students = new ArrayList<>() ;
		studentRepository.findByFiliere(filiere).forEach(students::add);
		return students ;
	}
	
	public List<Student> findStudentsByClasse(String classe) {
		return studentRepository.findByClasse(classe) ;
	}

}

