package com.example.codepower2.entities.submission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
    List<Submission> findAllByUserIdAndProblemId(Integer userId, Integer problemId);

    List<Submission> findAllByUserIdAndProblemIdAndVerdict(Integer userId, Integer problemId, String verdict);
}
