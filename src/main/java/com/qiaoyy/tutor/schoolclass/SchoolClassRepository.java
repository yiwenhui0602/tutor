package com.qiaoyy.tutor.schoolclass;

import com.qiaoyy.tutor.entity.AnnouncementManagementEntity;
import com.qiaoyy.tutor.entity.ClassInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface SchoolClassRepository extends JpaRepository<ClassInformationEntity, Integer> {
}
