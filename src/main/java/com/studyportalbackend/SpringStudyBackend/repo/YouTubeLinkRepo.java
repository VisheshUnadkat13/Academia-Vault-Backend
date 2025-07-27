package com.studyportalbackend.SpringStudyBackend.repo;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.model.YouTubeLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YouTubeLinkRepo extends JpaRepository<YouTubeLink,Long> {
    List<YouTubeLink> findBySubject(Subject subject);
}
