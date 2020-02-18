package com.qiaoyy.tutor.homework;

import com.qiaoyy.tutor.entity.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Integer> {
}
