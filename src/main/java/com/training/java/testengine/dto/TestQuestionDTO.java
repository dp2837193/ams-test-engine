package com.training.java.testengine.dto;

import com.training.java.testengine.entity.TestQuestionOption;

import java.util.List;

public class TestQuestionDTO {
    private Integer id;
    private Integer testId;
    private String question;
    private String type;
    private List<TestQuestionOption> options;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TestQuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<TestQuestionOption> options) {
        this.options = options;
    }
}
