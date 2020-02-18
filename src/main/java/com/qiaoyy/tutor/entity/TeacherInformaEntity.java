package com.qiaoyy.tutor.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:08
 */
@Entity
@Table(name = "teacher_informa", schema = "school", catalog = "")
public class TeacherInformaEntity {
    private int teacherId;
    private String teacherName;
    private String teacherGender;
    private String teacherPhone;
    private String teacherAccount;

    @Id
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_name")
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacher_gender")
    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    @Basic
    @Column(name = "teacher_phone")
    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    @Basic
    @Column(name = "teacher_account")
    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherInformaEntity that = (TeacherInformaEntity) o;
        return teacherId == that.teacherId &&
                Objects.equals(teacherName, that.teacherName) &&
                Objects.equals(teacherGender, that.teacherGender) &&
                Objects.equals(teacherPhone, that.teacherPhone) &&
                Objects.equals(teacherAccount, that.teacherAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherGender, teacherPhone, teacherAccount);
    }
}
