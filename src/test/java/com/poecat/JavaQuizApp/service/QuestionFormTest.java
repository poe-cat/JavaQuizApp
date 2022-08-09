package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
public class QuestionFormTest {

    @InjectMocks
    private QuizService quizService;
    @Mock
    private QuestionRepository questionRepository;

    private Question question1, question2;

    @BeforeEach
    void initializeQuestion() {
        Question question1 = new Question(11, "What is your name, Judith?",
                "Judith", "Elaine", "Margery", 1, 1);
        Question question2 = new Question(12, "What test should be created next?",
                "Integration", "Unit", "Both", 3, 1);
    }

    @Test
    public void shouldSetQuestionList() {
        //given
        QuestionForm questionForm = new QuestionForm(questionRepository);
        List<Question> questionList = new ArrayList<>();

        //then
        questionList.add(question1);
        questionList.add(question2);
        questionForm.setQuestions(questionList);

        //then
        assertThat(questionForm.getQuestions(), hasSize(2));
    }
}
