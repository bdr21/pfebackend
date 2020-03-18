package com.programming.techie.springngblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.springngblog.model.Teacher;
import com.programming.techie.springngblog.repository.TeacherRepository;


@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findAllTeachers() {
		return teacherRepository.findAll() ;
	}
	
	public List<Teacher> findTeachersByFiliere(String filiere) { 
		List<Teacher> teachers = new ArrayList<>() ;
		teacherRepository.findByFiliere(filiere).forEach(teachers::add);
		return teachers ;
	}

	public Optional<Teacher> findTeacherById(Long id) {
		return teacherRepository.findById(id) ;
	}
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher) ;
	}

	public long countTeachers() {
		return teacherRepository.count() ;
	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}
}
