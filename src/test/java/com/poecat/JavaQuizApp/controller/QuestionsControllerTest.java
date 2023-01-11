package com.poecat.JavaQuizApp.controller;


import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(QuestionsController.class)
public class QuestionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionRepository questionRepository;

    @Test
    public void authenticatedUserShouldBeAbleToAddQuestion() {


    }

}
