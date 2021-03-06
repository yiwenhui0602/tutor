package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author yiwenhui
 * @date 2020/2/18 16:07
 */
@Entity
@Table(name = "homework", schema = "school", catalog = "")
public class HomeworkEntity {
    private int hwId;
    private int classId;
    private String className;
    private int subjectId;
    private String hwTime;
    private String hwTitle;
    private String hwDetail;

    @Id
    @Column(name = "hw_id")
    public int getHwId() {
        return hwId;
    }

    public void setHwId(int hwId) {
        this.hwId = hwId;
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
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    @Basic
    @Column(name = "subjectId")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "hw_time")
    public String getHwTime() {
        return hwTime;
    }

    public void setHwTime(String hwTime) {
        this.hwTime = hwTime;
    }

    @Basic
    @Column(name = "hw_title")
    public String getHwTitle() {
        return hwTitle;
    }

    public void setHwTitle(String hwTitle) {
        this.hwTitle = hwTitle;
    }

    @Basic
    @Column(name = "hw_detail")
    public String getHwDetail() {
        return hwDetail;
    }

    public void setHwDetail(String hwDetail) {
        this.hwDetail = hwDetail;
    }

//    @Basic
//    @Column(name = "hw_file")
//    public String getHwFile() {
//        return hwFile;
//    }
//
//    public void setHwFile(String hwFile) {
//        this.hwFile = hwFile;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkEntity that = (HomeworkEntity) o;
        return hwId == that.hwId &&
                Objects.equals(hwTime, that.hwTime) &&
                Objects.equals(hwTitle, that.hwTitle) &&
                Objects.equals(hwDetail, that.hwDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hwId, hwTime, hwTitle, hwDetail);
    }
}
