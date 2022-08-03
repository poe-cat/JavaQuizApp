package com.poecat.JavaQuizApp.repository;

import com.poecat.JavaQuizApp.model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void shouldCreateNewUser() {
        User user = userRepository.save(new User(1L, "elaine@luned.com", "password", "Elaine", "Luned"));

        assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void shouldFindUserByFirstName() {
        User user = userRepository.findByFirstName("Elaine");
        assertThat(user.getFirstName()).isEqualTo("Elaine");
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void shouldUpdateUsersLastName() {
        User user = userRepository.findByFirstName("Elaine");
        user.setLastName("Fea");

        userRepository.save(user);

        User updatedUser = userRepository.findByFirstName("Elaine");

        assertThat(updatedUser.getLastName()).isEqualTo("Fea");
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void shouldDeleteUser() {
        User user = userRepository.findByFirstName("Elaine");

        userRepository.deleteById(user.getId());

        User deletedUser = userRepository.findByFirstName("Elaine");

        assertThat(deletedUser).isNull();
    }
}
