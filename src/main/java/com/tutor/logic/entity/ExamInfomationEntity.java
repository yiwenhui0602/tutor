package com.tutor.logic.entity;

import javax.persistence.*;

@Entity
@Table(name = "exam_information", schema = "school", catalog = "")
public class ExamInfomationEntity {
    private int examId;
    private String examName;
    private String examTime;
    private int subjectId;
    private String subjectName;
    private int classId;
    private String className;

    @Id
    @Column(name = "exam_id")
    public int getExamId() {
        return examId;
    }
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    @Basic
    @Column(name = "exam_name")
    public String getExamName() { return examName; }
    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Basic
    @Column(name = "exam_time")
    public String getExamTime() { return examTime; }
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    @Basic
    @Column(name = "subject_id")
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subject_name")
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "class_id")
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
