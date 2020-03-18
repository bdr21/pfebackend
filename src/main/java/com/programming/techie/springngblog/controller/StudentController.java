package com.programming.techie.springngblog.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.programming.techie.springngblog.dao.StudentDao;
import com.programming.techie.springngblog.model.Student;
import com.programming.techie.springngblog.model.Teacher;
import com.programming.techie.springngblog.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
		private byte[] bytes;
		
	 	@Autowired
	    private StudentService studentService ;
	 	
	 	@Autowired
	 	private StudentDao studentDao ;

	    
	    @GetMapping("/get")
		public List<Student> getStudents() {
			return studentService.findAllStudents();
		}
	    
	    @GetMapping("/get/filiere/{filiere}")
		public List<Student> getStudentsByFiliere(@PathVariable("filiere") String filiere) {
	    	return studentService.findStudentsByFiliere(filiere) ;
		}
	    
	    @GetMapping("/get/classe/{classe}")
		public List<Student> getStudentsByClasse(@PathVariable("classe") String classe) {
	    	return studentService.findStudentsByClasse(classe) ;
		}
	    
	    @GetMapping("/get/nos")
		public long getNOS() {
			return studentDao.count() ;
		}
	    
	    @GetMapping("/get/{id}")
		public Optional<Student> getStudent(@PathVariable("id") Long id) {
			return studentService.findStudentById(id);
		}
	    
	    @PostMapping("/add")
		public void createStudent(@RequestBody Student student) {
	    	student.setPicByte(this.bytes);
			studentService.save(student);
			this.bytes = null;
		}
	    
	    @PutMapping("/update")
		public void updateStudent(@RequestBody Student student) {
			studentService.save(student);
		}
	    
	    @DeleteMapping(path = { "/{id}" })
		public void deleteStudent(@PathVariable("id") Long id) {
			studentService.deleteStudent(id);
	    }
	    
	    @PostMapping("/upload")
		public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
			this.bytes = file.getBytes();
		}
		
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public Student registerStudent(@RequestBody Student student) {
	        return studentService.save(student);
	    }
}
