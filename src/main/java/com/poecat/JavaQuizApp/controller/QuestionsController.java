package com.poecat.JavaQuizApp.controller;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String saveQuestion(@Valid @ModelAttribute("question") Question question,
                               BindingResult result, Model model,  RedirectAttributes re) {

        if(result.hasErrors()) {
            re.addFlashAttribute("messageErr", "Something is wrong. Please try again.");

            return "redirect:/newQuestionForm";
        }
        question.setChoice(-1);
        questionRepository.save(question);
        re.addFlashAttribute("message",
                "Thank you for adding your question! " +
                        "It will randomly appear in our quiz, so be sure to check it out!");

        return "redirect:/newQuestionForm";
    }
}
