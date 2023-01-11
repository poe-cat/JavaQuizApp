package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionFormTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionForm questionForm;

    @Test
    void testGetQuestions() {
        List<Question> testQuestions = Arrays.asList(new Question(), new Question());
        questionForm.setQuestions(testQuestions);
        assertEquals(testQuestions, questionForm.getQuestions());
    }

    @Test
    void testGetAllQuestions() {
        List<Question> testQuestions = Arrays.asList(new Question(), new Question());
        when(questionRepository.findAll()).thenReturn(testQuestions);
        assertEquals(testQuestions, questionForm.getAllQuestions());
    }
}
