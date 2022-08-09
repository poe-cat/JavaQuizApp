package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import com.poecat.JavaQuizApp.repository.ResultRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;
    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private ResultRepository resultRepository;

    private Question question;

    @Test
    public void shouldAddContentToQuestionForm() {

        //given
        question = new Question(11, "What is your name, Judith?",
                "Judith", "Elaine", "Margery", 1, 1);
        List<Question> questionsList = new ArrayList<>();
        QuestionForm questionForm = new QuestionForm(questionRepository);

        //when
        questionsList.add(question);
        questionForm.setQuestions(questionsList);

        //then
        assertThat(questionForm.getQuestions().size(), is(1));
    }

    @Test
    public void shouldSaveNewQuestion() {
        //given
        List<Question> questionList = prepareQuestionsData();
        QuestionRepository questionRepository = mock(QuestionRepository.class);
        QuestionForm questionForm = new QuestionForm(questionRepository);
        questionForm.setQuestions(questionList);

        //when
        List<Question> questions = questionForm.getQuestions();

        //then
        assertThat(questions, hasSize(2));
    }

    @Test
    public void shouldNotGetAnyQuestions() {
        //given
        List<Question> questionList = prepareQuestionsData();
        QuestionRepository questionRepository = mock(QuestionRepository.class);
        QuestionForm questionForm = new QuestionForm(questionRepository);
        questionForm.setQuestions(questionList);
        given(questionRepository.getAllQuestions()).willReturn(Collections.emptyList());

        //when
        List<Question> questions = questionForm.getAllQuestions();

        //then
        assertThat(questions, hasSize(0));

    }

    private List<Question> prepareQuestionsData() {
        Question question1 = new Question(11, "What is your name, Judith?",
                "Judith", "Elaine", "Margery", 1, 1);
        Question question2 = new Question(12, "What test should be created next?",
                "Integration", "Unit", "Both", 3, 1);

        return Arrays.asList(question1, question2);
    }

}
