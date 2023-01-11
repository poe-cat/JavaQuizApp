package com.poecat.JavaQuizApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuizServiceTest {

    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private Question question;
    private QuizService quizService;

    @BeforeEach
    public void setUp() {
        quizService = new QuizService(questionRepository);
    }

    @Test
    void shouldGetSingleQuestionById() {

        //given
        int quesId = 1;

        //when
        when(questionRepository.getById(quesId)).thenReturn(question);
        Question question1 = quizService.getSingleQuestionById(quesId);

        //then
        assertEquals(question1.getOptionA(), question.getOptionA());
        verify(questionRepository, times(1)).getById(quesId);
    }

    @Test
    void shouldSaveQuestion() {
        Question question = mock(Question.class);

        quizService.saveQuestion(question);

        verify(questionRepository, times(1)).save(question);
    }
}
