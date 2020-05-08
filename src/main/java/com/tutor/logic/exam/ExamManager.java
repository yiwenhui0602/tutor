package com.tutor.logic.exam;

import com.tutor.logic.course.CourseRepository;
import com.tutor.logic.entity.CoursetableEntity;
import com.tutor.logic.entity.ExamInfomationEntity;
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

    public ExamInfomationEntity addCourse(ExamInfomationEntity entity) {
        return examRepository.saveAndFlush(entity);
    }
}