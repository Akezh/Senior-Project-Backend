package com.example.codepower2.entities.testcase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Integer> {
    List<TestCase> findTestCasesByProblemId(Integer problemId);
}
