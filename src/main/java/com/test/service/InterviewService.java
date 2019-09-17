package com.test.service;

import com.test.entity.Interview;
import com.test.entity.Stage;

public interface InterviewService {

	public void deleteInterview(Long id);

	public Stage createInterview(Long stageId, Interview interview);
}
