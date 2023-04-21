package com.example.codepower2.entities.track;

import com.example.codepower2.entities.problem.Difficulty;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Integer numberOfProblems;
}
