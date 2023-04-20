package com.example.codepower2.entities.problem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    @Query("SELECT p FROM Problem p WHERE p.id = ?1")
    Optional<Problem> findProblemById(Integer id);

}