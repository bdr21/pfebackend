package com.programming.techie.springngblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.techie.springngblog.model.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	
	public List<Note> findByFiliere(String filiere) ;
	
	public List<Note> findByClasse(String classe) ;
	
	public List<Note> findByTeacherFullName(String teacherFullName);

	public List<Note> findBySubject(String subject);

	public List<Note> findByStudentFullName(String studentFullName);

	public List<Note> findByValue(Long value);
	

}