package com.tutor.logic.student;

import com.tutor.logic.entity.HomeworkEntity;
import com.tutor.logic.entity.StudentInformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentManager {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentInformationEntity> queryAll() {
        List<StudentInformationEntity> list = studentRepository.findAll();
        return list;
    }

    public List<StudentInformationEntity> queryByClassId(Integer classId) {
        List<StudentInformationEntity> list = studentRepository.findByClassId(classId);
        return list;
    }

    public StudentInformationEntity addStudent(StudentInformationEntity entity) {
        return studentRepository.saveAndFlush(entity);
    }
}
