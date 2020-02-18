package com.qiaoyy.tutor.news;

import com.qiaoyy.tutor.entity.NewsManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface NewsRepository extends JpaRepository<NewsManagementEntity, Integer> {
}
