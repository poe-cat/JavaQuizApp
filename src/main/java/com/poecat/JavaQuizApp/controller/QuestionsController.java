package com.poecat.JavaQuizApp.controller;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/newQuestionForm")
    public String showNewQuestionForm(Model model) {

        Question question = new Question();
        model.addAttribute("question", question);
        return "new_question";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {

        question.setChoice(-1);
        questionRepository.save(question);
        return "redirect:/";
    }

}
