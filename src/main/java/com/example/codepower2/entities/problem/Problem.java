package com.example.codepower2.entities.problem;

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
@Table(name = "problem")
public class Problem {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String category; // Should be String[] (multiple categories)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private String description;
    private String solution;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Boolean solved;
}
