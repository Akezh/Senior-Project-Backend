package com.example.codepower2.entities.submission;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Submission {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "problem_id")
    public Integer problemId;

    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "language")
    public String language;

    @Column(name = "code")
    public String code;

    @Column(name = "verdict")
    public String verdict;
}