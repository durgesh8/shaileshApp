package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{

}
