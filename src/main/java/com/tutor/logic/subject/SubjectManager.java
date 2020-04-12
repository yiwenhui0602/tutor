package com.tutor.logic.subject;

import com.tutor.logic.entity.HomeworkEntity;
import com.tutor.logic.entity.SubjectInformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectManager {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectInformationEntity> queryAll() {
        List<SubjectInformationEntity> list = subjectRepository.findAll();
        return list;
    }

    public SubjectInformationEntity addSubject(SubjectInformationEntity entity) {
        return subjectRepository.saveAndFlush(entity);
    }

    public SubjectInformationEntity queryBySubjectId(Integer subjectId) {
        SubjectInformationEntity entity = subjectRepository.findBySubjectId(subjectId);
        return entity;
    }
}
