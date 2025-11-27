package com.studyportalbackend.SpringStudyBackend.service;

import com.studyportalbackend.SpringStudyBackend.model.Contect;
import com.studyportalbackend.SpringStudyBackend.repo.ContectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ContectService {

    @Autowired
    private ContectRepo contectRepo;

    public Contect addMesssage(Contect contect) throws IOException {
        return contectRepo.save(contect);
    }
}
