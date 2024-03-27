package com.utcn.demo.service;

import com.utcn.demo.model.Answer;
import com.utcn.demo.model.Question;
import com.utcn.demo.model.User;
import com.utcn.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;


    public void createAnswer(User author, Question question, AnswerCreateDTO answerCreateDTO) {
        Answer answer = new Answer();
        answer.setAuthor(author);
        answer.setQuestion(question);
        answer.setAnswer(answerCreateDTO.getAnswer());
        answer.setCreationDate(new Date());
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public void deleteAllAnswers() {
        answerRepository.deleteAll();
    }

    public void updateAnswer(AnswerUpdateDTO answerUpdateDTO) {
        Answer answer = answerRepository.findById(answerUpdateDTO.getAnswerId()).orElse(null);
        if (answer != null) {
            answer.setAnswer(answerUpdateDTO.getAnswer());
            answerRepository.save(answer);
        }
    }

    public Answer retrieveAnswer(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    public List<Answer> retrieveAnswers() {
        return answerRepository.findAll();
    }
}
