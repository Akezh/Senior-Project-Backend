package com.example.codepower2.problem;

import com.example.codepower2.entities.problem.Difficulty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ProblemCreate implements Serializable {
    private String title;
    private String category;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private String description;
    private String solution;
    private List<TestCaseCreate> testCases;
}
