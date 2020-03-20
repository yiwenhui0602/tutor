package com.tutor.logic.schoolclass;

import com.tutor.logic.entity.ClassInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface SchoolClassRepository extends JpaRepository<ClassInformationEntity, Integer> {
}
