package com.programming.techie.springngblog.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.programming.techie.springngblog.model.Teacher;
import com.programming.techie.springngblog.repository.TeacherRepository;
import com.programming.techie.springngblog.service.TeacherService;


@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

			private byte[] bytes;
			
		 	@Autowired
		    private TeacherService teacherService ;
		 		    
		    @GetMapping("/get")
			public List<Teacher> getTeachers() {
				return teacherService.findAllTeachers();
			}
		    
		    @GetMapping("/get/filiere/{filiere}")
			public List<Teacher> getTeachersByFiliere(@PathVariable("filiere") String filiere) {
		    	return teacherService.findTeachersByFiliere(filiere) ;
			}
		    
		    @GetMapping("/get/not")
			public long getNOT() {
				return teacherService.countTeachers() ;
			}
		    
		    @GetMapping("/get/{id}")
			public Optional<Teacher> getTeacher(@PathVariable("id") Long id) {
				return teacherService.findTeacherById(id);
			}
		   
		    
		    @PostMapping("/add")
			public void createTeacher(@RequestBody Teacher teacher) {
		    	teacher.setPicByte(this.bytes);
				teacherService.saveTeacher(teacher);
				this.bytes = null;
			}
		    
		    @PutMapping("/update")
			public void updateTeacher(@RequestBody Teacher teacher) {
				teacherService.saveTeacher(teacher);
			}
		    
		    @DeleteMapping(path = { "/{id}" })
			public void deleteTeacher(@PathVariable("id") Long id) {
				teacherService.deleteTeacher(id);
		    }
		    
		    @PostMapping("/upload")
			public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
				this.bytes = file.getBytes();
			}
			
		    @RequestMapping(value = "/register", method = RequestMethod.POST)
		    public void registerTeacher(@RequestBody Teacher teacher) {
		        teacherService.saveTeacher(teacher);
		    }
	

}
