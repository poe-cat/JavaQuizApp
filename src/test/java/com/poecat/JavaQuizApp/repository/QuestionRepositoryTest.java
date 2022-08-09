package com.poecat.JavaQuizApp.repository;

import com.poecat.JavaQuizApp.model.Question;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    private Question question;


    @Test
    @Rollback(false)
    public void shouldSaveNewQuestion() {

        question = new Question(11, "What is your name, Judith?",
                "Judith", "Elaine", "Margery", 1, 1);

        assertThat(question.getQuesId()).isGreaterThan(0);
    }
}
