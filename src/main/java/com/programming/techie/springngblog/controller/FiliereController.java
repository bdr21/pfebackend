package com.programming.techie.springngblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.programming.techie.springngblog.model.Filiere;
import com.programming.techie.springngblog.service.FiliereService;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

		 	@Autowired
		    private FiliereService filiereService ;
		 		    
		    @GetMapping("/get")
			public List<Filiere> getFilieres() {
				return filiereService.findAllFilieres();
			}
		    
		    @GetMapping("/get/nof")
			public long getNOF() {
				return filiereService.countFilieres() ;
			}
		    
		    @GetMapping("/get/{id}")
			public Optional<Filiere> getFiliere(@PathVariable("id") String id) {
				return filiereService.findFiliereById(id);
			}
		   
		    
		    @PostMapping("/add")
			public void createFiliere(@RequestBody Filiere filiere) {
				filiereService.saveFiliere(filiere);
			}
		    
		    @PostMapping("/add/teacher")
			public void addTeacher(@RequestBody String teacher , @PathVariable("id") String id) {
		    	filiereService.findFiliereById(id);
				filiereService.addTeacher(teacher , id) ;
			}
		    
		    @PutMapping("/update")
			public void updateFiliere(@RequestBody Filiere filiere) {
				filiereService.saveFiliere(filiere);
			}
		    
		    @DeleteMapping(path = { "/{id}" })
			public void deleteFiliere(@PathVariable("id") String id) {
				filiereService.deleteFiliere(id);
		    }
	

}
