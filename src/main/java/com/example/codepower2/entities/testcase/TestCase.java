package com.example.codepower2.entities.testcase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "test")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCase implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "problem_id")
    public Integer problemId;

    @Column(name = "input", columnDefinition = "TEXT")
    public String input;

    @Column(name = "output", columnDefinition = "TEXT")
    public String output;
}
