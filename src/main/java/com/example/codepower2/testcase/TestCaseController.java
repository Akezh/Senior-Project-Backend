package com.example.codepower2.testcase;

import com.example.codepower2.entities.testcase.TestCase;
import com.example.codepower2.entities.testcase.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestCaseController {

    private final TestCaseRepository testCaseRepository;

    @CrossOrigin
    @GetMapping("/problem/{problemId}")
    public List<TestCase> getTests(@PathVariable Integer problemId) {
        return testCaseRepository.findTestCasesByProblemId(problemId);
    }

    @CrossOrigin
    @PostMapping("/")
    public void save(@RequestBody TestCase testCase) {
        testCaseRepository.save(testCase);
    }
}
