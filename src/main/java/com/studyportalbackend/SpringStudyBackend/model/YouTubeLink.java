package com.studyportalbackend.SpringStudyBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class YouTubeLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 500)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY) // Many links can belong to one subject
    @JoinColumn(name = "subject_id", nullable = false) // Foreign key column
    private Subject subject;
}
