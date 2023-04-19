package com.example.codepower2.entities.submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    List<Submission> findAllByUserIdAndAndProblemId(Integer userId, Integer problemId);
}
