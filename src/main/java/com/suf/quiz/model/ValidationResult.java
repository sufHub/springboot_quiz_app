package com.suf.quiz.model;

import lombok.Data;

import java.util.Map;

@Data
public class ValidationResult {
    private String correctCount;

    public ValidationResult(String correctCount){
        this.correctCount = correctCount;
    }

}

