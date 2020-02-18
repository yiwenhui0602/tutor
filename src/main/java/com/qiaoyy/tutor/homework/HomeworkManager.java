package com.qiaoyy.tutor.homework;

import com.qiaoyy.tutor.entity.HomeworkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeworkManager {

    @Autowired
    private HomeworkRepository homeworkRepository;

    public List<HomeworkEntity> queryAll() {
        List<HomeworkEntity> list = homeworkRepository.findAll();
        return list;
    }

    public HomeworkEntity addHomework(HomeworkEntity entity) {
        return homeworkRepository.saveAndFlush(entity);
    }
}
