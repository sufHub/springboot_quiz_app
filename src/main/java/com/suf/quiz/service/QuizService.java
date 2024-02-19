package com.suf.quiz.service;

import com.suf.quiz.model.Quiz;
import com.suf.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public boolean checkAnswer(Long questionID, String[] answer) {

        Optional<Quiz> correctAnswer = quizRepository.findById(questionID);

        String result = Arrays.stream(answer)
                .map(Objects::toString) // use null-safe conversion
                .collect(Collectors.joining(", "));

        return correctAnswer.get().getCorrectAnswer().equalsIgnoreCase(result);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
