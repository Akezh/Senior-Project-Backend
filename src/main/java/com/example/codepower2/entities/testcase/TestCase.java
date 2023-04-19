package com.example.codepower2.entities.testcase;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "test")
public class TestCase implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "problem_id")
    public Integer problemId;

    @Column(name = "input")
    public String input;

    @Column(name = "output")
    public String output;
}
