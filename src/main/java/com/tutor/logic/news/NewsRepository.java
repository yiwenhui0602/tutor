package com.tutor.logic.news;

import com.tutor.logic.entity.NewsManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface NewsRepository extends JpaRepository<NewsManagementEntity, Integer> {
}
