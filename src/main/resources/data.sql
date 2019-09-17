
INSERT INTO JOB(JOB_ID,JOB_NAME,JOB_DESC,CREATED_BY,CREATED_TS) VALUES 
(51,'developer','software developer job','Shailesh',{ts '2019-09-14 18:47:52.69'});

INSERT INTO STAGE(STAGE_ID,STAGE_NAME,STAGE_DESC,JOB_ID) VALUES 
(51,'Application Review','review the application',51),
(52,'Phone Interview','Telephonic interview',51),
(53,'Assessment','Taking assessment exam of the candidate',51),
(54,'Offered','Offer made',51),
(55,'Hired','Hiring of candidate is done',51);

INSERT INTO INTERVIEW(INTERVIEW_ID,INTERVIEW_NAME,INTERVIEW_DESC,STAGE_ID) VALUES 
(51,'Interview first round','1st round of interview',51),
(52,'Interview second round','2nd round of interview',51),
(53,'Interview first round','1st round of interview',52),
(54,'Interview second round','2nd round of interview',52),
(55,'Interview first round','1st round of interview',53),
(56,'Interview second round','2nd round of interview',53),
(57,'Interview first round','1st round of interview',54),
(58,'Interview second round','2nd round of interview',54),
(59,'Interview first round','1st round of interview',55),
(60,'Interview second round','2nd round of interview',55);