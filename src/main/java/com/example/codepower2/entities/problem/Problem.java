package com.example.codepower2.entities.problem;

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
    private String testCases; // Should be List<Pair<String,String>> (List of inputs and outputs);

}
