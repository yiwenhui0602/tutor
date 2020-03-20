package com.tutor.logic.news;

import com.tutor.logic.entity.NewsManagementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsManager {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsManagementEntity> queryAll() {
        List<NewsManagementEntity> list = newsRepository.findAll();
        return list;
    }

    public NewsManagementEntity addNews(NewsManagementEntity entity) {
        return newsRepository.saveAndFlush(entity);
    }
}
