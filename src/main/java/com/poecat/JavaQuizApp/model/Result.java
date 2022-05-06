package com.poecat.JavaQuizApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int totalCorrect = 0;
    private double percent;

    public Result() {
    }

    public Result(int id, String username, int totalCorrect, double percent) {
        super();
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", totalCorrect=" + totalCorrect +
                ", percent=" + percent +
                '}';
    }
}
