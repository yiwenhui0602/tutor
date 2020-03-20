package com.tutor.logic.course;

import com.tutor.logic.entity.CoursetableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseManager {

    @Autowired
    private CourseRepository courseRepository;

    public List<CoursetableEntity> queryAll() {
        List<CoursetableEntity> list = courseRepository.findAll();
        return list;
    }

    public CoursetableEntity addCourse(CoursetableEntity entity) {
        return courseRepository.saveAndFlush(entity);
    }
}
