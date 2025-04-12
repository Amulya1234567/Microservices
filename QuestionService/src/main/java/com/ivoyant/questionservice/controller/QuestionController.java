package com.ivoyant.questionservice.controller;

import com.ivoyant.questionservice.entity.Question;
import com.ivoyant.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping("/get")
    public List<Question> get(){
        return questionService.get();
    }

    @GetMapping("/get/{questionId}")
    public Question getById(@PathVariable Long questionId) {
        return questionService.getById(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

}
