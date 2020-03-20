package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:08
 */
@Entity
@Table(name = "subject_information", schema = "school", catalog = "")
public class SubjectInformationEntity {
    private int subjectId;
    private String subjectName;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectInformationEntity that = (SubjectInformationEntity) o;
        return subjectId == that.subjectId &&
                Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName);
    }
}
