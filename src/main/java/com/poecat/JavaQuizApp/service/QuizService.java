package com.poecat.JavaQuizApp.service;

import com.poecat.JavaQuizApp.model.Question;
import com.poecat.JavaQuizApp.model.Result;
import com.poecat.JavaQuizApp.repository.QuestionRepository;
import com.poecat.JavaQuizApp.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    Question question;
    @Autowired
    QuestionForm questionForm;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    Result result;
    @Autowired
    ResultRepository resultRepository;

    public final double questionsOnPage = 10;

    public QuestionForm getQuestions() {
        List<Question> allQues = questionRepository.findAll();
        List<Question> qList = new ArrayList<Question>();

        Random random = new Random();

        for(int i = 0; i < questionsOnPage; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        questionForm.setQuestions(qList);

        return questionForm;
    }

    public int getResult(QuestionForm qForm) {
        int correct = 0;

        for(Question question: qForm.getQuestions())
            if(question.getAnswer() == question.getChoice())
                correct++;

        return correct;
    }

    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        saveResult.setPercent(result.getPercent());
        resultRepository.save(saveResult);
    }


    public List<Result> getTopScore() {

        List<Result> sList = resultRepository.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }
}