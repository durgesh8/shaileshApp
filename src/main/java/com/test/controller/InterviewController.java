package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Interview;
import com.test.entity.Stage;
import com.test.service.InterviewService;

@RestController
public class InterviewController {
	
	@Autowired
	InterviewService service;
	
     @DeleteMapping(value="/deleteInterview/{interviewID}")
	public void deleteInterview(@PathVariable("interviewID") Long interviewID) {
		service.deleteInterview(interviewID);
	}
     
     @PostMapping(value="/createInterview/{stageId}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
     public Stage createInterview(@PathVariable("stageId") Long stageId, @RequestBody Interview interview) {
    	return  service.createInterview(stageId, interview);
     }
}
