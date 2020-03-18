package com.programming.techie.springngblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.techie.springngblog.model.Filiere;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, String>{
	
}
