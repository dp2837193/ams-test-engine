package com.training.java.testengine.dao;

import com.training.java.testengine.entity.TestQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestQuestionOptionRepository extends JpaRepository<TestQuestionOption, Integer> {
}
