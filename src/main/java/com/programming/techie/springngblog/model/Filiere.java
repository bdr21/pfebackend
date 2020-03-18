package com.programming.techie.springngblog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Filiere {
	
	@Id
    private String id;
	private String teachers ;
	private String classes ;
	private String students ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getStudents() {
		return students;
	}
	public void setStudents(String students) {
		this.students = students;
	}


}
