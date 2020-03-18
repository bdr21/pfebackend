package com.programming.techie.springngblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.springngblog.model.Filiere;
import com.programming.techie.springngblog.repository.FiliereRepository;


@Service
public class FiliereService {
	
	@Autowired
	private FiliereRepository filiereRepository;
	
	public List<Filiere> findAllFilieres() {
		return filiereRepository.findAll() ;
	}

	public Optional<Filiere> findFiliereById(String id) {
		return filiereRepository.findById(id) ;
	}
	public void saveFiliere(Filiere filiere) {
		filiereRepository.save(filiere) ;
	}

	public long countFilieres() {
		return filiereRepository.count() ;
	}

	public void deleteFiliere(String id) {
		filiereRepository.deleteById(id);
	}

	public void addTeacher(String teacher , String id) {
		Optional<Filiere> filiere = filiereRepository.findById(id) ;
	}
}