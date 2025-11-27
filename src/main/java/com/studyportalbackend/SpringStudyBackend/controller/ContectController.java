package com.studyportalbackend.SpringStudyBackend.controller;

import com.studyportalbackend.SpringStudyBackend.model.Contect;
import com.studyportalbackend.SpringStudyBackend.service.ContectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContectController {

    @Autowired
    private ContectService contectService;

    @PostMapping
    public ResponseEntity<?> addMessage(@RequestBody Contect contect)
    {
        Contect savedContect=null;

        try{
            savedContect=contectService.addMesssage(contect);
            return new ResponseEntity<>(savedContect, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
