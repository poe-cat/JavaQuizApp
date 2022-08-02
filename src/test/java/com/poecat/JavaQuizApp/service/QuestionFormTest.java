package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class QuestionFormTest {

    @Test
    void getAllQuestions() {

        //given
        List<Question> questions = prepareQuestionData();
        QuestionRepository questionRepository = mock(QuestionRepository.class);
        QuestionForm questionForm = new QuestionForm(questionRepository);
        given(questionRepository.getAllQuestions()).willReturn(questions);

        //when
        List<Question> questionList = questionForm.getAllQuestions();

        //then
        assertThat(questionList, hasSize(2));
    }

    private List<Question> prepareQuestionData() {
        Question question1 = new Question(1, "Jak ma na imię Judyta?", "Judyta", "Małgorzata", "Ewa", 1, -1);
        Question question2 = new Question(2, "Jak ma na imię Małgorzata?", "Judyta", "Małgorzata", "Ewa", 2, -1);

        return Arrays.asList(question1, question2);
    }
}
