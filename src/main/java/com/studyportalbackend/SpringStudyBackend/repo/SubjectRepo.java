package com.studyportalbackend.SpringStudyBackend.repo;

import com.studyportalbackend.SpringStudyBackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
    List<Subject> findBySemesterAndDepartment(String semester, String department);
}
