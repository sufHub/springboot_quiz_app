package com.suf.quiz.repository;

import com.suf.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT q.correctAnswer FROM Quiz q WHERE q.question = :question")
    String findCorrectAnswerByQuestion(String question);

    String findCorrectAnswerById(Integer Id);
}
