package com.training.java.testengine.service;

import com.training.java.testengine.dao.TestQuestionOptionRepository;
import com.training.java.testengine.dao.TestQuestionRepository;
import com.training.java.testengine.dao.TestRepository;
import com.training.java.testengine.dto.TestQuestionDTO;
import com.training.java.testengine.entity.TestEntity;
import com.training.java.testengine.entity.TestQuestionEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestQuestionRepository testQuestionRepository;

    @Autowired
    private TestQuestionOptionRepository testQuestionOptionRepository;

    public Integer addTest(TestEntity testEntity){
        TestEntity addedTest = testRepository.save(testEntity);
        return addedTest.getId();
    }

    public void addQuestion(TestQuestionDTO testQuestionDTO) throws Exception {
        Optional<TestEntity> test = testRepository.findById(testQuestionDTO.getTestId());
        if(!test.isPresent()){
            throw new Exception("No test found with id "+testQuestionDTO.getTestId());
        }
        TestQuestionEntity question = new TestQuestionEntity();
        BeanUtils.copyProperties(testQuestionDTO, question);
        testQuestionRepository.save(question);
//        testQuestionOptionRepository.saveAll(testQuestionDTO.getOptions());
    }

    public ResponseEntity<List<TestEntity>> getAllTests() {
        return ResponseEntity.ok(new ArrayList<>(testRepository.findAll()));
    }

    public ResponseEntity<TestEntity> getTestById(int testId){
        Optional<TestEntity> test = testRepository.findById(testId);
        return test.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<List<TestQuestionEntity>> getTestQuestions(int testId) {
        return ResponseEntity.ok(testQuestionRepository.findByTestId(testId));
    }
}
