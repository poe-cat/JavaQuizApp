package com.poecat.JavaQuizApp.controller;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.model.Result;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import com.poecat.JavaQuizApp.repository.ResultRepository;
import com.poecat.JavaQuizApp.service.QuestionForm;
import com.poecat.JavaQuizApp.service.QuizService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private QuizService quizService;
    @Mock
    private ResultRepository resultRepository;

    @Test
    public void shouldShowHomePage() throws Exception {

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }

    @Test
    public void homePageMethod() {
        MainController mainController = new MainController();
        assertEquals("index", mainController.showHomePage());
    }

    @Test
    public void shouldGetAllScores() {
        //given
        List<Result> resultList = prepareResultData();
        ResultRepository resultRepository = mock(ResultRepository.class);


//
//        //when
//        List<Question> questions;
//
//        //then
//        assertThat(questions, hasSize(2));


    }

    private List<Result> prepareResultData() {
        Result result1 = new Result(1, "Elaine", 10, 100);
        Result result2 = new Result(2, "Maisie", 5, 50);
        Result result3 = new Result(3, "William", 3, 30);
        Result result4 = new Result(4, "Blaise", 4, 40);

        return Arrays.asList(result1, result2, result3, result4);
    }
}
