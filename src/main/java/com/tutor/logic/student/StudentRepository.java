package com.tutor.logic.student;

import com.tutor.logic.entity.HomeworkEntity;
import com.tutor.logic.entity.StudentInformationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentInformationEntity, Integer> {
    @Query(value = "from StudentInformationEntity where classId=:classId")
    List<StudentInformationEntity> findByClassId(@Param("classId") Integer classId);
}
