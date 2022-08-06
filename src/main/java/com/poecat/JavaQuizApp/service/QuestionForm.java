package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionForm {

    private List<Question> questions;
    private QuestionRepository questionRepository;

    public QuestionForm(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
