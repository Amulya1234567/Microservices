package com.ivoyant.questionservice.service;

import com.ivoyant.questionservice.entity.Question;
import com.ivoyant.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question create(Question question){
        return questionRepository.save(question);
    }

    public List<Question> get(){
        return questionRepository.findAll();
    }

    public Question getById(Long questionId){
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found "));
    }

    public List<Question> getQuestionsOfQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }

}
