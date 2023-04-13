package com.example.codepower2.problem;

import com.example.codepower2.entities.common.ConfirmationResponse;
import com.example.codepower2.entities.problem.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/problem")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping("/{problemId}")
    public Problem getProblem(@PathVariable Integer problemId) {
        return problemService.getProblem(problemId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addProblem(@RequestBody Problem problem) {
        problemService.addProblem(problem);

        ConfirmationResponse confirmationResponse = new ConfirmationResponse("Problem is added successfully");

        return new ResponseEntity<>(confirmationResponse, HttpStatus.CREATED);
    }
}