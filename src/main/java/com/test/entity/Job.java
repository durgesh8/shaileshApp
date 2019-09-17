package com.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Job extends AbstractEntity implements Serializable{
	
	
	private static final long serialVersionUID = -8848248376174831454L;
	public Job() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	private Long jobId;
	
	@Column(name="JOB_NAME",nullable=false)
	private String jobName;
	
	@Column(name="JOB_DESC",nullable=false)
	private String jobDescription;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="job")
	private List<Stage> stageList;
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public List<Stage> getStageList() {
		return stageList;
	}

	public void setStageList(List<Stage> stageList) {
		this.stageList = stageList;
	}

	
	
	
	
}
