package com.poecat.JavaQuizApp.repository;

import com.poecat.JavaQuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    public Question findById(int id);
    public List<Question> findAll();

}
