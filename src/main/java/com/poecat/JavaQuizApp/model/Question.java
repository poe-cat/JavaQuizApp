package com.poecat.JavaQuizApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;

    @NotEmpty
    @Size(min = 10)
    private String title;

    @NotEmpty
    private String optionA;

    @NotEmpty
    private String optionB;

    @NotEmpty
    private String optionC;

    private int answer;

    private int choice;

    public Question() {
        super();
    }

    public Question(int quesId, String title, String optionA,
                    String optionB, String optionC, int answer, int choice) {
        super();
        this.quesId = quesId;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.answer = answer;
        this.choice = choice;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "Question [quesId=" + quesId + ", " +
                "title=" + title + ", " +
                "optionA=" + optionA + ", " +
                "optionB=" + optionB + ", " +
                "optionC=" + optionC + ", " +
                "answer=" + answer + ", " +
                "choice=" + choice + "]";
    }
}

