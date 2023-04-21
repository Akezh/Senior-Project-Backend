package com.example.codepower2.problem;

import com.example.codepower2.entities.common.ConfirmationResponse;
import com.example.codepower2.entities.problem.Problem;
import com.example.codepower2.entities.testcase.TestCase;
import com.example.codepower2.entities.testcase.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/problem")
@RequiredArgsConstructor
@CrossOrigin
public class ProblemController {

    private final ProblemService problemService;

    private final TestCaseRepository testCaseRepository;

    @GetMapping("")
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }
    @GetMapping("/{problemId}")
    public Problem getProblem(@PathVariable Integer problemId) {
        return problemService.getProblem(problemId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addProblem(@RequestBody ProblemCreate problemCreate) {
        Problem problem = Problem.builder()
                .category(problemCreate.getCategory())
                .description(problemCreate.getDescription())
                .difficulty(problemCreate.getDifficulty())
                .title(problemCreate.getTitle())
                .solution(problemCreate.getSolution())
                .statement(problemCreate.getStatement())
                .build();
        problem = problemService.addProblem(problem);

        Problem finalProblem = problem;
        problemCreate.getTestCases().forEach(testCaseCreate -> {
            TestCase testCase = TestCase.builder()
                    .input(testCaseCreate.getInput())
                    .output(testCaseCreate.getOutput())
                    .problemId(finalProblem.getId()).build();
            testCaseRepository.save(testCase);
        });

        ConfirmationResponse confirmationResponse = new ConfirmationResponse("Problem is added successfully");

        return new ResponseEntity<>(confirmationResponse, HttpStatus.CREATED);
    }
}