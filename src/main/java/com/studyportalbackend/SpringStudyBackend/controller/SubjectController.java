package com.studyportalbackend.SpringStudyBackend.controller;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.CryptoPrimitive;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects(@RequestParam String semester,@RequestParam String department)
    {
        List<Subject> subjects=subjectService.getSubjectsBySemesterAndDepartment(semester,department);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }



//    @GetMapping
//    public ResponseEntity<List<Subject>> getAllSubject()
//    {
//        return new ResponseEntity<>(subjectService.getAllSubjects(),HttpStatus.OK);
//    }


}
