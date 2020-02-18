package com.qiaoyy.tutor.announcements;

import com.qiaoyy.tutor.entity.AnnouncementManagementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnnouncementsManager {

    @Autowired
    private AnnouncementsRepository announcementsRepository;

    public List<AnnouncementManagementEntity> queryAll() {
        List<AnnouncementManagementEntity> list = announcementsRepository.findAll();
        return list;
    }

    public AnnouncementManagementEntity addAnnouncements(AnnouncementManagementEntity entity) {
        return announcementsRepository.saveAndFlush(entity);
    }
}
