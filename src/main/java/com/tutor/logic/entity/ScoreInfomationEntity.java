package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scores_information", schema = "school", catalog = "")
public class ScoreInfomationEntity {
    private int scoreId;
    private int examId;
    private int studentId;
    private String studentName;
    private String scoreNum;

    @Id
    @Column(name = "score_id")
    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    @Basic
    @Column(name = "exam_id")
    public int getExamId() {
        return examId;
    }
    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "score_num")
    public String getScoreNum() {
        return scoreNum;
    }
    public void setScoreNum(String scoreNum) {
        this.scoreNum = scoreNum;
    }
}
