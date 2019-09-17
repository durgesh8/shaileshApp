package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.entity.Interview;
import com.test.entity.Stage;
import com.test.repository.InterviewRepository;
import com.test.repository.StageRepository;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	InterviewRepository repository;
	
	@Autowired
	StageRepository stageRepository;

	@Override
	public void deleteInterview(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Stage createInterview(Long stageId, Interview interview) {
           Optional<Stage> stage= stageRepository.findById(stageId);
           if(stage.isPresent()) {
        	   Stage stageFound=stage.get();
        	   List<Interview> interviewList= new ArrayList<>();
        	   List<Interview> interviewpersistedList= stageFound.getInterviewList();
        	   interviewList.addAll(interviewpersistedList);
        	   interview.setStage(stageFound);
        	  interviewList.add(interview);
        	  stageFound.getInterviewList().clear();
        	  stageFound.getInterviewList().addAll(interviewList);
        	  return stageRepository.save(stageFound);
           }
           else {
        	   throw new RuntimeException("Stage id is not found");
           }

	}

}
