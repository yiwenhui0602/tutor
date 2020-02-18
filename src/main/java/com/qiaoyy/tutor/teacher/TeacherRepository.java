package com.qiaoyy.tutor.teacher;

import com.qiaoyy.tutor.entity.TeacherInformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface TeacherRepository extends JpaRepository<TeacherInformaEntity, Integer> {
}
