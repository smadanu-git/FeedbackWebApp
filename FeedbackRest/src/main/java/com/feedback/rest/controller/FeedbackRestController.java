package com.feedback.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entities.Users;
import com.feedback.service.FeedbackService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class FeedbackRestController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping(path="/myReviews", produces = "application/json")
    public ResponseEntity<List<Users>> findAll(){
		List<Users> userList = feedbackService.getAdminDasboard();
		
        return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);

    }
	
	@PostMapping(path="/addEmployee", produces = "application/json")
    public ResponseEntity<List<Users>> addEmployee(){
		List<Users> userList = feedbackService.getAdminDasboard();
		
        return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);

    }

}
