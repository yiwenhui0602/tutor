package com.qiaoyy.tutor.subject;

import com.qiaoyy.tutor.entity.SubjectInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface SubjectRepository extends JpaRepository<SubjectInformationEntity, Integer> {
}
