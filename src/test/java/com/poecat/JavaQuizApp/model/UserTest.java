package com.poecat.JavaQuizApp.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @ParameterizedTest
    @CsvSource({"1, elaine@gmail.com, elaineLuned, Elaine, Luned"})
    public void userShouldHaveAllParameters(Long id, String email, String password, String firstName, String lastName) {

        assertThat(id, notNullValue());
        assertThat(email, notNullValue());
        assertThat(email.length(), lessThanOrEqualTo(45));
        assertThat(password, notNullValue());
        assertThat(password.length(), lessThanOrEqualTo(64));
        assertThat(firstName.length(), lessThanOrEqualTo(20));
        assertThat(lastName.length(), lessThanOrEqualTo(20));
    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        User user = new User();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> user.setEmail("wrong email"));
    }

    @Test
    void validEmailShouldBeSet() {

        //given
        User user = new User();

        //when
        user.setEmail("elaine@gmail.com");

        //then
        assertThat(user.getEmail(), is("elaine@gmail.com"));
    }
}
