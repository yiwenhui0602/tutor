package com.tutor.logic.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author yiwenhui
 * @date 2020/2/18 16:07
 */
@Entity
@Table(name = "coursetable", schema = "school", catalog = "")
public class CoursetableEntity {
    private int courseId;
    private Date courseDate;
    private String courseAddress;
    private String courseTime;
    private String subjectName;

    @Id
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_date")
    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    @Basic
    @Column(name = "course_address")
    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    @Basic
    @Column(name = "course_time")
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "subject_name")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursetableEntity that = (CoursetableEntity) o;
        return courseId == that.courseId &&
                Objects.equals(courseDate, that.courseDate) &&
                Objects.equals(courseAddress, that.courseAddress) &&
                Objects.equals(courseTime, that.courseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseDate, courseAddress, courseTime);
    }
}
