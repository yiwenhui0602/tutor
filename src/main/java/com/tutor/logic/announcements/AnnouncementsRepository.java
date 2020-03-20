package com.tutor.logic.announcements;

import com.tutor.logic.entity.AnnouncementManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 2017/5/30.
 */
@Repository
public interface AnnouncementsRepository extends JpaRepository<AnnouncementManagementEntity, Integer> {
}
