package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.entity.Interview;
import com.test.entity.Job;
import com.test.entity.Stage;
import com.test.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Override
	public List<Job> fetchJobs() {
		return jobRepository.findAll();
	}

	@Override
	public Job createJob(Job job) {
		List<Stage> fixedStageList = new ArrayList<>();
		Stage stage1 = new Stage();
		stage1.setJob(job);
		stage1.setStageName("Offered");
		stage1.setStageDescription("Offer made");
		fixedStageList.add(stage1);
		Stage stage2 = new Stage();
		stage2.setJob(job);
		stage2.setStageName("Hired");
		stage2.setStageDescription("Hiring of candidate is done");
		fixedStageList.add(stage2);

		job.getStageList().addAll(fixedStageList);

		if (!CollectionUtils.isEmpty(job.getStageList())) {
			job.getStageList().stream().forEach(stage -> {
				if (!CollectionUtils.isEmpty(stage.getInterviewList())) {
					stage.getInterviewList().stream().forEach(interview -> {
						interview.setStage(stage);
					});
				}
				stage.setJob(job);
			});
		}
		return jobRepository.save(job);
	}

	@Override
	public Job editJob(Long jobId, Job job) {
		if (jobId == null || jobId == 0) {
			throw new RuntimeException("Job Id cant be null while updating job");
		} else {
			Optional<Job> persistedJobOP = jobRepository.findById(jobId);
			if (persistedJobOP.isPresent()) {
				Job persistedJob = persistedJobOP.get();
				if (job.getJobName() != null)
					persistedJob.setJobName(job.getJobName());
				if (job.getJobDescription() != null)
					persistedJob.setJobDescription(job.getJobDescription());
				if (!CollectionUtils.isEmpty(job.getStageList())) {
					List<Stage> stageList = job.getStageList();
					stageList.stream().forEach(stage -> {
						if (!CollectionUtils.isEmpty(stage.getInterviewList())) {
							List<Interview> interviewList = stage.getInterviewList();
							interviewList.stream().forEach(interview -> {
								interview.setStage(stage);
							});

							stage.getInterviewList().clear();
							stage.setInterviewList(interviewList);

						}
						stage.setJob(persistedJob);
						
					});

				} else
					persistedJob.getStageList().clear();

				return jobRepository.save(persistedJob);
			} else {
				throw new RuntimeException("Job id passed cant be found in database");
			}
		}

	}

}
