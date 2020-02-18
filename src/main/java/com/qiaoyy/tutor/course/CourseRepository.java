package com.qiaoyy.tutor.course;

import com.qiaoyy.tutor.entity.CoursetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface CourseRepository extends JpaRepository<CoursetableEntity, Integer> {
}
