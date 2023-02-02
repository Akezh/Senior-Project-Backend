package com.example.codepower2.entities.track;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private String category; // Should be String[] (multiple categories)
    private Integer numberOfProblems;
}
