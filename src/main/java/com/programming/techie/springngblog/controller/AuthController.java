package com.programming.techie.springngblog.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.programming.techie.springngblog.dto.LoginRequest;
import com.programming.techie.springngblog.dto.RegisterRequest;
import com.programming.techie.springngblog.model.Student;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.service.AuthService;
import com.programming.techie.springngblog.service.AuthenticationResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @GetMapping("/user/get")
	public Optional<org.springframework.security.core.userdetails.User> getUser() {
		return authService.getCurrentUser() ;
	}
    
    /*@GetMapping("/user/get/{id}")
	public Optional<User> getUser(@PathVariable("id") Long id) {
		return authService.getUserById(id) ;
	}*/
    
    @GetMapping("/user/get/{username}")
	public Optional<User> getUser(@PathVariable("username") String username) {
		return authService.getUserByUsername(username) ;
	}
    

    @PostMapping("/auth/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
