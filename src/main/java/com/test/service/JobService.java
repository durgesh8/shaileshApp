package com.test.service;

import java.util.List;

import com.test.entity.Job;

public interface JobService {

	public List<Job> fetchJobs();
	
	public Job createJob(Job job);

	public Job editJob(Long jobId, Job job);
}
