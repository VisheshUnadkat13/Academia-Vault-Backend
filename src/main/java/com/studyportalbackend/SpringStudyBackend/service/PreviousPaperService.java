package com.studyportalbackend.SpringStudyBackend.service;

import com.studyportalbackend.SpringStudyBackend.model.PreviousYearPaper;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.repo.PreviousYearPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreviousPaperService {
    @Autowired // Injects an instance of PreviousYearPaperRepository
    private PreviousYearPaperRepository previousYearPaperRepository;




    public List<PreviousYearPaper> getPreviousYearPapersBySubject(Subject subject) {
        return previousYearPaperRepository.findBySubject(subject);
    }

    public Optional<PreviousYearPaper> getPreviousYearPaperById(Long id) {
        return previousYearPaperRepository.findById(id);
    }

//    public Optional<PreviousYearPaper> getPaperById(Long id) {
//        return previousYearPaperRepository.findById(id);
//    }
}
