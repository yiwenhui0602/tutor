package com.tutor.logic.exam;

import com.tutor.logic.course.CourseRepository;
import com.tutor.logic.entity.CoursetableEntity;
import com.tutor.logic.entity.ExamInfomationEntity;
import com.tutor.logic.entity.ScoreInfomationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager {

    @Autowired
    private ExamRepository examRepository;

    public List<ExamInfomationEntity> queryAll() {
        List<ExamInfomationEntity> list = examRepository.findAll();
        return list;
    }

    public ExamInfomationEntity addExam(ExamInfomationEntity entity) {
        return examRepository.saveAndFlush(entity);
    }

    // 查询id为xx的考试信息对象，结果是数组
    public List<ExamInfomationEntity> queryExamById(Integer examId) {
        List<ExamInfomationEntity> list = examRepository.findByExamId(examId);
        return list;
    }
}