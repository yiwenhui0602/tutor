package com.tutor.logic.exam;

import com.tutor.logic.entity.ExamInfomationEntity;
import com.tutor.logic.entity.ScoreInfomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<ExamInfomationEntity, Integer> {
    // 该注解自动绑定方法，添加查询条件
    @Query(value = "from ExamInfomationEntity where examId=:examId")
    List<ExamInfomationEntity> findByExamId(@Param("examId") Integer studentId);
}
