package com.poecat.JavaQuizApp.controller;

import com.poecat.JavaQuizApp.model.Result;
import com.poecat.JavaQuizApp.service.QuestionForm;
import com.poecat.JavaQuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;

    public boolean submitted = false;


    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }


    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
        if(username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name first!");
            return "redirect:/";
        }

        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz.html";
    }
}
