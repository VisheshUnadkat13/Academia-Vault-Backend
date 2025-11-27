package com.studyportalbackend.SpringStudyBackend.repo;


import com.studyportalbackend.SpringStudyBackend.model.Contect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContectRepo extends JpaRepository<Contect,Long> {
}
