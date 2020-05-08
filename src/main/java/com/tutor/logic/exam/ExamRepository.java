package com.tutor.logic.exam;

import com.tutor.logic.entity.ExamInfomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamInfomationEntity, Integer> {
}
