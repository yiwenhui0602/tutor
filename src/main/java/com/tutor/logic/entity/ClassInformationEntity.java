package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author yiwenhui
 * @date 2020/2/18 16:07
 */
@Entity
@Table(name = "class_information", schema = "school", catalog = "")
public class ClassInformationEntity {
    private int classId;
    private String className;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassInformationEntity that = (ClassInformationEntity) o;
        return classId == that.classId &&
                Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className);
    }
}
