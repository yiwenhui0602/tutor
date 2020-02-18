package com.qiaoyy.tutor.announcements;

import com.qiaoyy.tutor.entity.ClassInformationEntity;
import com.qiaoyy.tutor.schoolclass.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolClassManager {

    @Autowired
    private SchoolClassRepository classRepository;

    public List<ClassInformationEntity> queryAll() {
        List<ClassInformationEntity> list = classRepository.findAll();
        return list;
    }

    public ClassInformationEntity addClass(ClassInformationEntity entity) {
        return classRepository.saveAndFlush(entity);
    }
}
