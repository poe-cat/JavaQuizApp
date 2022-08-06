package com.poecat.JavaQuizApp.repository;

import com.poecat.JavaQuizApp.model.Result;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResultRepositoryTest {

    @Autowired
    private ResultRepository resultRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void shouldCreateNewResult() {
        Result result = new Result(1, "Elaine", 10, 100);

        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void shouldFindResultById() {
        Result result = resultRepository.getById(1);
        assertThat(result.getId()).isEqualTo(1);
    }

}