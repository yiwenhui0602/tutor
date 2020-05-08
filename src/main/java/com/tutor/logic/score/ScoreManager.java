package com.tutor.logic.score;

import com.tutor.logic.entity.HomeworkEntity;
import com.tutor.logic.entity.ScoreInfomationEntity;
import com.tutor.logic.homework.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreManager {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreInfomationEntity> queryAll() {
        List<ScoreInfomationEntity> list = scoreRepository.findAll();
        return list;
    }

    public ScoreInfomationEntity addScore(ScoreInfomationEntity entity) {
        return scoreRepository.saveAndFlush(entity);
    }

    public List<ScoreInfomationEntity> queryByStudentId(Integer studentId) {
        List<ScoreInfomationEntity> list = scoreRepository.findByStudentId(studentId);
        return list;
    }

    public List<ScoreInfomationEntity> queryByExamId(Integer examId) {
        List<ScoreInfomationEntity> list = scoreRepository.findByExamId(examId);
        return list;
    }
}
