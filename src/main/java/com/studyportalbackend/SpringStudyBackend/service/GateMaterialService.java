package com.studyportalbackend.SpringStudyBackend.service;

import com.studyportalbackend.SpringStudyBackend.model.GateMaterial;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.repo.GateMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateMaterialService {

    @Autowired
    private GateMaterialRepo gateMaterialRepo;

    public List<GateMaterial> getGateMaterialsBySubject(Subject subject) {
        return gateMaterialRepo.findBySubject(subject);
    }

    public Optional<GateMaterial> getGateMaterialById(Long gateMaterialId) {
        return  gateMaterialRepo.findById(gateMaterialId);
    }

    public void deleteGateMaterial(Long id) {
        gateMaterialRepo.deleteById(id);
    }
}
