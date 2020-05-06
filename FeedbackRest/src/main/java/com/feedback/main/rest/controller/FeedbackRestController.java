package com.feedback.main.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.main.entities.User;
import com.feedback.main.service.FeedbackService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class FeedbackRestController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping(path="/adminDashboard", produces = "application/json")
    public ResponseEntity<List<User>> findAll(){
		List<User> userList = feedbackService.getAdminDasboard();
		
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

    }
	
	@PostMapping(path="/addEmployee", produces = "application/json")
    public ResponseEntity<List<User>> addEmployee(){
		List<User> userList = feedbackService.getAdminDasboard();
		
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

    }

}
