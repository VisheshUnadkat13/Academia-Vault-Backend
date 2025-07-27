package com.studyportalbackend.SpringStudyBackend.controller;

import com.studyportalbackend.SpringStudyBackend.model.GateMaterial;
import com.studyportalbackend.SpringStudyBackend.model.Subject;
import com.studyportalbackend.SpringStudyBackend.service.GateMaterialService;
import com.studyportalbackend.SpringStudyBackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gate-materials")
@CrossOrigin(origins = "*")
public class GateMaterialController {

    @Autowired
    private GateMaterialService gateMaterialService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{subjectId}")
    public ResponseEntity<List<GateMaterial>> getGateMaterialsForSubject(@PathVariable Long subjectId)
    {
        Optional<Subject> subjectOptional=subjectService.getSubjectById(subjectId);
        if(subjectOptional.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<GateMaterial> gateMaterials=gateMaterialService.getGateMaterialsBySubject(subjectOptional.get());
        return new ResponseEntity<>(gateMaterials,HttpStatus.OK);
    }

    @GetMapping({"/view/{gateMaterialId}", "/download/{gateMaterialId}"})
    public ResponseEntity<Void> redirectToGateMaterial(@PathVariable Long gateMaterialId)
    {
        Optional<GateMaterial> gateMaterial=gateMaterialService.getGateMaterialById(gateMaterialId);
        if(gateMaterial.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        GateMaterial gateMaterial1=gateMaterial.get();
        String fileUrl=gateMaterial1.getFileUrl();
        try {
            if (fileUrl == null || fileUrl.trim().isEmpty()) {
                System.err.println("fileUrl for GATE material ID " + gateMaterialId + " is null or empty.");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(new URI(fileUrl.trim()))
                    .build();
        } catch (Exception e) {
            System.err.println("Error redirecting to GATE material URL: " + fileUrl);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGateMaterial(@PathVariable Long id)
    {
        Optional<GateMaterial> gateMaterial=gateMaterialService.getGateMaterialById(id);

        if(gateMaterial.isPresent())
        {
            gateMaterialService.deleteGateMaterial(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
