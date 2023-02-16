package com.training.java.testengine.dao;

import com.training.java.testengine.entity.TestQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestQuestionRepository extends JpaRepository<TestQuestionEntity, Integer> {
    List<TestQuestionEntity> findByTestId(Integer testId);
}
