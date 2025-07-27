package com.studyportalbackend.SpringStudyBackend.service;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.model.YouTubeLink;
import com.studyportalbackend.SpringStudyBackend.repo.YouTubeLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YouTubeLinkService {
    @Autowired
    private YouTubeLinkRepo youTubeLinkRepo;

    public List<YouTubeLink> getYouTubeLinkBySubject(Subject subject) {
        return youTubeLinkRepo.findBySubject(subject);
    }
}
