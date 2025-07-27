package com.studyportalbackend.SpringStudyBackend.controller;


import com.studyportalbackend.SpringStudyBackend.model.PreviousYearPaper;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.service.PreviousPaperService;
import com.studyportalbackend.SpringStudyBackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/papers")
@CrossOrigin(origins = "*")
public class PreviousPaperController {


    @Autowired
    private PreviousPaperService previousPaperService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{subjectId}")
    public ResponseEntity<List<PreviousYearPaper>> getPapersForSubject(@PathVariable Long subjectId) {
        // Find the subject by ID first
        Optional<Subject> subjectOptional = subjectService.getSubjectById(subjectId);
        if (subjectOptional.isEmpty()) {
            // If subject not found, return 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // If subject found, fetch papers associated with it
        List<PreviousYearPaper> papers = previousPaperService.getPreviousYearPapersBySubject(subjectOptional.get());
        return new ResponseEntity<>(papers, HttpStatus.OK);
    }

    @GetMapping({"/view/{paperId}", "/download/{paperId}"})
    public  ResponseEntity<Void> redirectToPaperUrl(@PathVariable Long paperId)
    {
        Optional<PreviousYearPaper> previousYearPaper=previousPaperService.getPreviousYearPaperById(paperId);
        if(previousYearPaper==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PreviousYearPaper paper=previousYearPaper.get();
        String fileUrl=paper.getFileUrl();

        try {

            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(new URI(fileUrl))
                    .build();
        } catch (Exception e) {
            System.err.println("Error redirecting to paper URL: " + fileUrl + " - " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/{paperId}")
//    public ResponseEntity<Optional<PreviousYearPaper>> getPaperById(@PathVariable Long paperId)
//    {
//        Optional<PreviousYearPaper> previousYearPaper=previousPaperService.getPaperById(paperId);
//        return new ResponseEntity<>(previousYearPaper,HttpStatus.OK);
//    }

    


}
