package com.studyportalbackend.SpringStudyBackend.controller;


import com.studyportalbackend.SpringStudyBackend.model.Material;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.service.MaterialService;
import com.studyportalbackend.SpringStudyBackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materials")
@CrossOrigin(origins = "*")

public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @Autowired
    private SubjectService subjectService;


    @GetMapping("/{subjectId}")
    public ResponseEntity<List<Material>> getMaterialForSubject(@PathVariable Long subjectId)
    {
        Optional<Subject> subjectOptional=subjectService.getSubjectById(subjectId);
        if(subjectOptional.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Material> materials=materialService.getMaterialsBySubject(subjectOptional.get());
        return new ResponseEntity<>(materials,HttpStatus.OK);
    }

    @GetMapping({"/view/{materialId}", "/download/{materialId}"})
    public ResponseEntity<Void> redirectToMaterialUrl(@PathVariable Long materialId)
    {
        Optional<Material> materialOptional=materialService.getMaterialById(materialId);
        if(materialOptional.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Material material = materialOptional.get();
        String fileUrl = material.getFileUrl();

        try {

            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(new URI(fileUrl))
                    .build();
        } catch (Exception e) {

            System.err.println("Error redirecting to material URL: " + fileUrl);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaterial(@PathVariable Long id)
    {
        Optional<Material> material=materialService.getMaterialById(id);
        if(material.isPresent())
        {
            materialService.getMaterialById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
