package com.poecat.JavaQuizApp.repository;

import com.poecat.JavaQuizApp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    public void createNewUser() {
        User user = userRepository.save(new User(1L, "elaine@luned.com", "password", "Elaine", "Luned"));

        assertThat(user.getId()).isGreaterThan(0);
    }
}
