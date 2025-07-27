package com.studyportalbackend.SpringStudyBackend.repo;

import com.studyportalbackend.SpringStudyBackend.model.Material;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<Material,Long> {

    List<Material> findBySubject(Subject subject);
}
