package com.example.codepower2.entities.trackproblem;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "track_problem")
public class TrackProblem implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "track_id")
    public Integer trackId;

    @Column(name = "problem_id")
    public Integer problemId;
}
