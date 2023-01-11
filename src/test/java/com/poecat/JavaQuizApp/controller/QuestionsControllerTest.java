package com.poecat.JavaQuizApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
class QuestionsControllerTest {

    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private BindingResult bindingResult;
    @InjectMocks
    private QuestionsController questionsController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(questionsController).build();
    }

    @Test
    void showNewQuestionForm() throws Exception {
        mockMvc.perform(get("/newQuestionForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_question"))
                .andExpect(model().attributeExists("question"));
    }
}
