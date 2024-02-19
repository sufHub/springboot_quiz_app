package com.suf.quiz.controller;

import com.suf.quiz.model.Quiz;
import com.suf.quiz.model.UserAnswer;
import com.suf.quiz.model.ValidationResult;
import com.suf.quiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public String home() {
        return "quiz";
    }

    @GetMapping("/load")
    @ResponseBody
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }


    @PostMapping("/validate")
    @ResponseBody
    public ValidationResult validateQuiz(@RequestBody List<UserAnswer> userAnswers) {

            int correctCount = 0;
            int totalQuestions = 0;
            Set<String> wrongAnswers = new HashSet<String>();

            for (UserAnswer qa : userAnswers) {
                totalQuestions++;

                Long questionID = qa.getId() + 1;

                if (quizService.checkAnswer(questionID, qa.getAnswer())) {
                    correctCount++;
                }else{
                    wrongAnswers.add(String.valueOf(totalQuestions));
                }
            }

            return new ValidationResult(correctCount +" out of "
                    +totalQuestions+ " .Wrong for :"+wrongAnswers.toString());
        }

    }
