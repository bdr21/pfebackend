package com.programming.techie.springngblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.springngblog.model.Note;
import com.programming.techie.springngblog.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository ;
	
	public List<Note> findAllNotes() {
		return noteRepository.findAll() ;
	}

	public List<Note> findNotesByValue(Long value) {
		return noteRepository.findByValue(value) ;
	}

	public List<Note> findNotesByTeacherFullName(String teacherFullName) {
		return noteRepository.findByTeacherFullName(teacherFullName) ;
	}
	
	public List<Note> findNotesByStudentFullName(String studentFullName) {
		return noteRepository.findByStudentFullName(studentFullName) ;
		
	}
	
	public List<Note> findNotesByFiliere(String filiere) {
		return noteRepository.findByFiliere(filiere) ;
	}
	
	public List<Note> findNotesByClasse(String classe) {
		return noteRepository.findByClasse(classe) ;
	}

	public long countNotes() {
		return noteRepository.count() ;
	}

	public Optional<Note> findNoteById(Long id) {
		return noteRepository.findById(id) ;
	}

	public void saveNote(Note note) {
		noteRepository.save(note) ;
	}

	public void deleteNote(Long id) {
		noteRepository.deleteById(id);
	}

}
