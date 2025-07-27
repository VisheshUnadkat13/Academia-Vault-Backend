package com.studyportalbackend.SpringStudyBackend.repo;

import com.studyportalbackend.SpringStudyBackend.model.GateMaterial;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateMaterialRepo extends JpaRepository<GateMaterial,Long> {
    List<GateMaterial> findBySubject(Subject subject);
}
