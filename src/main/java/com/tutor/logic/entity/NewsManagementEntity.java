package com.tutor.logic.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 何金成
 * @date 2020/2/18 16:08
 */
@Entity
@Table(name = "news_management", schema = "school", catalog = "")
public class NewsManagementEntity {
    private int newsId;
    private String newsTitle;
    private String newsSubtitle;
    private String newsDate;
    private String newsUrl;

    @Id
    @Column(name = "news_id")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_title")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_subtitle")
    public String getNewsSubtitle() {
        return newsSubtitle;
    }

    public void setNewsSubtitle(String newsSubtitle) {
        this.newsSubtitle = newsSubtitle;
    }

    @Basic
    @Column(name = "news_date")
    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    @Basic
    @Column(name = "news_url")
    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsManagementEntity that = (NewsManagementEntity) o;
        return newsId == that.newsId &&
                Objects.equals(newsTitle, that.newsTitle) &&
                Objects.equals(newsSubtitle, that.newsSubtitle) &&
                Objects.equals(newsDate, that.newsDate) &&
                Objects.equals(newsUrl, that.newsUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsTitle, newsSubtitle, newsDate, newsUrl);
    }
}
