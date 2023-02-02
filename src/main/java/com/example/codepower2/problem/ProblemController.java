package com.example.codepower2.problem;

import com.example.codepower2.entities.problem.Problem;
import lombok.RequiredArgsConstructor;
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
    public void addProblem(@RequestBody Problem problem) {
        problemService.addProblem(problem);
    }
}