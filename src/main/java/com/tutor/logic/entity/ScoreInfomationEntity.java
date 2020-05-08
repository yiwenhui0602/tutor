//package com.tutor.logic.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "scores_information", schema = "school", catalog = "")
//public class ScoreInfomationEntity {
//    private int scoreId;
//    private String scoreName;
//    private int subjectId;
//    private String subjectName;
//    private int classId;
//    private String className;
//    private int studentId;
//    private String studentName;
//    private String scoreNum;
//    private String studentGender;
//    private String studentAccount;
//
//    @Id
//    @Column(name = "score_id")
//    public int getScoreId() {
//        return scoreId;
//    }
//
//    public void setScoreId(int scoreId) {
//        this.scoreId = scoreId;
//    }
//
//    @Basic
//    @Column(name = "score_name")
//    public  String getScoreName() { return scoreName; }
//    public void setScoreName(String scoreName) {
//        this.scoreName = scoreName;
//    }
//
//    @Basic
//    @Column(name = "subject_id")
//    public int getSubjectId() {
//        return subjectId;
//    }
//
//    @Basic
//    @Column(name = "class_id")
//    public int getClassId() {
//        return classId;
//    }
//
//    public void setClassId(int classId) {
//        this.classId = classId;
//    }
//
//    @Basic
//    @Column(name = "student_name")
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    @Basic
//    @Column(name = "student_gender")
//    public String getStudentGender() {
//        return studentGender;
//    }
//
//    public void setStudentGender(String studentGender) {
//        this.studentGender = studentGender;
//    }
//
//    @Basic
//    @Column(name = "student_account")
//    public String getStudentAccount() {
//        return studentAccount;
//    }
//
//    public void setStudentAccount(String studentAccount) {
//        this.studentAccount = studentAccount;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        return  false;
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        StudentInformationEntity that = (StudentInformationEntity) o;
////        return studentId == that.studentId &&
////                Objects.equals(studentName, that.studentName) &&
////                Objects.equals(studentGender, that.studentGender) &&
////                Objects.equals(studentAccount, that.studentAccount);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(studentId, studentName, studentGender);
//    }
//}
