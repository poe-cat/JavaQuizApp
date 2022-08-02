package com.poecat.JavaQuizApp.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {

    @ParameterizedTest
    @CsvSource({"1, Blaise, 8, 80"})
    public void resultShouldHaveAllParameters(int id, String username, int totalCorrect, double percent) {

        assertThat(id, notNullValue());
        assertThat(username, isA(String.class));
        assertThat(totalCorrect, lessThanOrEqualTo(10));
        assertThat(percent, lessThanOrEqualTo(100.0));
    }

    @ParameterizedTest
    @CsvSource({"10, 100", "6, 60", "4, 40", "1, 10"})
    public void calculateIfPercentIsAdequate(int totalCorrect, double percent) {

        int calculatedPercent = (int) (percent/totalCorrect);

        assertThat(calculatedPercent, equalTo(10));
    }
}
