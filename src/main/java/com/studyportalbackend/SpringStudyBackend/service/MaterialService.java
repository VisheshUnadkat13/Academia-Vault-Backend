package com.studyportalbackend.SpringStudyBackend.service;


import com.studyportalbackend.SpringStudyBackend.model.Material;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.repo.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MaterialService {
    @Autowired
    private MaterialRepo materialRepo;


    public List<Material> getMaterialsBySubject(Subject subject) {
        return materialRepo.findBySubject(subject);
    }

    public Optional<Material> getMaterialById(Long materialId) {
        return materialRepo.findById(materialId);
    }

    public void daleteMaterial(Long id) {
      materialRepo.deleteById(id);
    }
}
