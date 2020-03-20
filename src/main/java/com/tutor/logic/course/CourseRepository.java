package com.tutor.logic.course;

import com.tutor.logic.entity.CoursetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface CourseRepository extends JpaRepository<CoursetableEntity, Integer> {
}
