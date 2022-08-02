package com.poecat.JavaQuizApp.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class QuestionTest {


    @ParameterizedTest
    @CsvSource({"1, Is Python an easy language?, Yes, No, Yes and no, 3, 3"})
    void questionShouldHaveAllParameters(int quesId, String title, String optionA,
                                         String optionB, String optionC, int answer, int choice) {

        assertThat(quesId, notNullValue());
        assertThat(title, containsString("?"));
        assertThat(optionA, notNullValue());
        assertThat(optionB, notNullValue());
        assertThat(optionC, notNullValue());
        assertThat(answer, isA(Integer.class));
        assertThat(choice, notNullValue());
        assertThat(title.length(), not(lessThan(10)));
    }
}
