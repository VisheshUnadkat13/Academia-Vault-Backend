package com.studyportalbackend.SpringStudyBackend.service;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo repo;

    public List<Subject> getSubjectsBySemesterAndDepartment(String semester, String department) {
        return repo.findBySemesterAndDepartment(semester,department);
    }

    public Optional<Subject> getSubjectById(Long subjectId) {
        return repo.findById(subjectId);
    }


//    public List<Subject> getAllSubjects() {
//        return repo.findAll();
//    }
}
