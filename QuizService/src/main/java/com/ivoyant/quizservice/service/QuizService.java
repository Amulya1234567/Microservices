package com.ivoyant.quizservice.service;

import com.ivoyant.quizservice.entity.Quiz;
import com.ivoyant.quizservice.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public Quiz add(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public List<Quiz> get(){
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizzes = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizzes;
    }

    public Quiz getById(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }

}
