package com.example.codepower2.entities.problem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    Optional<Problem> findByTitle(String title);

}