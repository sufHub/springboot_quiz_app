package com.suf.quiz.model;

import lombok.Data;

@Data
public class UserAnswer {

    private Long id;
    private String question;
    private String[] answer;

}
