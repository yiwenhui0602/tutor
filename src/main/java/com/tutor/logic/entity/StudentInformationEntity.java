package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author yiwenhui
 * @date 2020/2/18 16:08
 */
@Entity
@Table(name = "student_information", schema = "school", catalog = "")
public class StudentInformationEntity {
    private int studentId;
    private String studentName;
    private String studentGender;
    private String studentAccount;
    private int classId;
    private String parentName;
    private String parentRelation;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_gender")
    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    @Basic
    @Column(name = "student_account")
    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    @Basic
    @Column(name = "parent_name")
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Basic
    @Column(name = "parent_relation")
    public String getParentRelation() {
        return parentRelation;
    }
    public void setParentRelation(String parentRelation) {
        this.parentRelation = parentRelation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInformationEntity that = (StudentInformationEntity) o;
        return studentId == that.studentId &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(studentGender, that.studentGender) &&
                Objects.equals(studentAccount, that.studentAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentGender, studentAccount);
    }
}
