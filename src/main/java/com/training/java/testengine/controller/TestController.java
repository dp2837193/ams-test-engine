package com.training.java.testengine.controller;

import com.training.java.testengine.dto.TestQuestionDTO;
import com.training.java.testengine.entity.TestEntity;
import com.training.java.testengine.entity.TestQuestionEntity;
import com.training.java.testengine.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    public ResponseEntity<String> addTest(@RequestBody TestEntity testEntity){
        Integer testId = testService.addTest(testEntity);
        return ResponseEntity.ok(testId.toString());
    }

    @PostMapping("/{testId}/question")
    public ResponseEntity<String> addQuestion(@PathVariable("testId") Integer testId, @RequestBody TestQuestionDTO testQuestionDTO){
        try{
            testService.addQuestion(testQuestionDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add question", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Question added successfully");
    }

    @GetMapping
    public ResponseEntity<List<TestEntity>> getAllTests(){
        return testService.getAllTests();
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestEntity> getTestById(@PathVariable("testId") Integer testId){
        return testService.getTestById(testId);
    }

    @GetMapping("/{testId}/question")
    public ResponseEntity<List<TestQuestionEntity>> getTestQuestionsByTestId(@PathVariable("testId") Integer testId){
        return testService.getTestQuestions(testId);
    }
}
