package com.tutor.logic.subject;

import com.tutor.logic.entity.HomeworkEntity;
import com.tutor.logic.entity.SubjectInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface SubjectRepository extends JpaRepository<SubjectInformationEntity, Integer> {
    @Query(value = "from SubjectInformationEntity where subjectId=:subjectId")
    SubjectInformationEntity findBySubjectId(@Param("subjectId") Integer subjectId);
}
