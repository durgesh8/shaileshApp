package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
