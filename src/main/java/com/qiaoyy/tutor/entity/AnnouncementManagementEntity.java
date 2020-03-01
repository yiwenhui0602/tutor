package com.qiaoyy.tutor.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:07
 */
@Entity
@Table(name = "announcement_management", schema = "school", catalog = "")
public class AnnouncementManagementEntity {
    private int noticeId;
    private String noticeTitle;
    private String noticeTime;
    private String noticeAuthor;
    private String noticeDetail;

    @Id
    @Column(name = "notice_id")
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    @Basic
    @Column(name = "notice_title")
    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    @Basic
    @Column(name = "notice_time")
    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    @Basic
    @Column(name = "notice_author")
    public String getNoticeAuthor() {
        return noticeAuthor;
    }

    public void setNoticeAuthor(String noticeAuthor) {
        this.noticeAuthor = noticeAuthor;
    }

    @Basic
    @Column(name = "notice_detail")
    public String getNoticeDetail() {
        return noticeDetail;
    }

    public void setNoticeDetail(String noticeDetail) {
        this.noticeDetail = noticeDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnouncementManagementEntity that = (AnnouncementManagementEntity) o;
        return noticeId == that.noticeId &&
                Objects.equals(noticeTitle, that.noticeTitle) &&
                Objects.equals(noticeTime, that.noticeTime) &&
                Objects.equals(noticeAuthor, that.noticeAuthor) &&
                Objects.equals(noticeDetail, that.noticeDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeId, noticeTitle, noticeTime, noticeAuthor, noticeDetail);
    }
}
