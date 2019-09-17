package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Job;
import com.test.service.JobService;

@RestController
public class JobController {

	@Autowired
	JobService service;
	
	@GetMapping(value="/job",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Job> fetchJobs() {
		List<Job> result=new ArrayList<Job>();
		 result =service.fetchJobs();
		 return result;
	}
	
	@PostMapping(value="/job",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Job createJob(@RequestBody Job job) {
		return service.createJob(job);
	}
	
	@PutMapping(value="/job/{jobId}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Job editJob(@PathVariable(value="jobId") Long jobId, @RequestBody Job job) {
		return service.editJob(jobId,job);
	}
	
}
