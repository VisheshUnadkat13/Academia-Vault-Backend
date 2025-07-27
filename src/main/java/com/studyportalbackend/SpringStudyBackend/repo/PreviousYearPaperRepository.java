package com.studyportalbackend.SpringStudyBackend.repo;

import com.studyportalbackend.SpringStudyBackend.model.PreviousYearPaper;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreviousYearPaperRepository extends JpaRepository<PreviousYearPaper,Long> {
    List<PreviousYearPaper> findBySubject(Subject subject);

    PreviousYearPaper findPreviousYearPaperById(Long paperId);
}
