package com.studyportalbackend.SpringStudyBackend.controller;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.model.YouTubeLink;
import com.studyportalbackend.SpringStudyBackend.service.SubjectService;
import com.studyportalbackend.SpringStudyBackend.service.YouTubeLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/youtube-links")
@CrossOrigin(origins = "*")
public class YouTubeLinkController {

    @Autowired
    private YouTubeLinkService youTubeLinkService;

    @Autowired
    private SubjectService subjectService;


    @GetMapping("/{subjectId}")
    public ResponseEntity<List<YouTubeLink>> getYouTubeLinkForSubject(@PathVariable Long subjectId)
    {
        Optional<Subject> subjectOptional=subjectService.getSubjectById(subjectId);
        if(subjectOptional.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<YouTubeLink> youTubeLinks=youTubeLinkService.getYouTubeLinkBySubject(subjectOptional.get());
        return new ResponseEntity<>(youTubeLinks,HttpStatus.OK);
    }

}
