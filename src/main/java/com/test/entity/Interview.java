package com.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Interview extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6296045026771645118L;
	public Interview() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INTERVIEW_ID")
	private Long interviewId;
	
	@Column(name="INTERVIEW_NAME", nullable=false)
	private String interviewName;
	
	@Column(name="INTERVIEW_DESC", nullable=false)
	private String interviewDescription;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("stageId")
    @JoinColumn(name="STAGE_ID")
	private Stage stage;
	
	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getInterviewDescription() {
		return interviewDescription;
	}

	public void setInterviewDescription(String interviewDescription) {
		this.interviewDescription = interviewDescription;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
