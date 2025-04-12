package com.ivoyant.quizservice.controller;

import com.ivoyant.quizservice.entity.Quiz;
import com.ivoyant.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/add")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping("/get")
    public List<Quiz> get(){
        return quizService.get();
    }

    @GetMapping("/get/{id}")
    public Quiz getById(@PathVariable Long id){
        return quizService.getById(id);
    }
}
