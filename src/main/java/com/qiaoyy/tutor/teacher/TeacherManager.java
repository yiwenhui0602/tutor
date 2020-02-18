package com.qiaoyy.tutor.teacher;

import com.qiaoyy.tutor.entity.TeacherInformaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherManager {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherInformaEntity> queryAll() {
        List<TeacherInformaEntity> list = teacherRepository.findAll();
        return list;
    }

    public TeacherInformaEntity addTeacher(TeacherInformaEntity entity) {
        return teacherRepository.saveAndFlush(entity);
    }
}
