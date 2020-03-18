package com.programming.techie.springngblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.programming.techie.springngblog.model.Note;
import com.programming.techie.springngblog.service.NoteService;


@RestController
@RequestMapping("/api/notes")
public class NoteController {
			
		 	@Autowired
		    private NoteService noteService ;
		 		    
		    @GetMapping("/get")
			public List<Note> getNotes() {
				return noteService.findAllNotes();
			}
		    
		    @GetMapping("/get/filiere/{filiere}")
			public List<Note> getNotesByFiliere(@PathVariable("filiere") String filiere) {
		    	return noteService.findNotesByFiliere(filiere) ;
			}
		    
		    @GetMapping("/get/classe/{classe}")
			public List<Note> getNotesByClasse(@PathVariable("classe") String classe) {
		    	return noteService.findNotesByClasse(classe) ;
			}
		    
		    @GetMapping("/get/value/{value}")
			public List<Note> getNotesByValue(@PathVariable("value") Long value) {
		    	return noteService.findNotesByValue(value) ;
			}
		    
		    @GetMapping("/get/teacherFullName/{teacherFullName}")
			public List<Note> getNotesByTeacherFullName(@PathVariable("teacherFullName") String teacherFullName) {
		    	return noteService.findNotesByTeacherFullName(teacherFullName) ;
			}
		    
		    @GetMapping("/get/studentFullName/{studentFullName}")
			public List<Note> getNotesByStudentFullName(@PathVariable("studentFullName") String studentFullName) {
		    	return noteService.findNotesByStudentFullName(studentFullName) ;
			}
		    
		    @GetMapping("/get/non")
			public long getNON() {
				return noteService.countNotes() ;
			}
		    
		    @GetMapping("/get/{id}")
			public Optional<Note> getNote(@PathVariable("id") Long id) {
				return noteService.findNoteById(id);
			}
		   
		    
		    @PostMapping("/add")
			public void createNote(@RequestBody Note note) {    	
				noteService.saveNote(note);
			}
		    
		    @PutMapping("/update")
			public void updateNote(@RequestBody Note note) {
				noteService.saveNote(note);
			}
		    
		    @DeleteMapping(path = { "/{id}" })
			public void deleteNote(@PathVariable("id") Long id) {
				noteService.deleteNote(id);
		    }
}