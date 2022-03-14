package com.exercise.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.service.IQueryService;

@RestController
public class QueryController {
	
	@Autowired
	private IQueryService iQueryService;
	
	@PostMapping(value = "/q1")
	ResponseEntity<String> query(@RequestParam String question) {
		String answer = iQueryService.query(question);
		if(answer != null && (answer.contains("That’s great") || answer.contains("Here you go, solve the question"))){
			return new ResponseEntity<>(answer,HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid Response", HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
