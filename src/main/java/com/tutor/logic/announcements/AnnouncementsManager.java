package com.tutor.logic.announcements;

import com.tutor.logic.entity.AnnouncementManagementEntity;
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
