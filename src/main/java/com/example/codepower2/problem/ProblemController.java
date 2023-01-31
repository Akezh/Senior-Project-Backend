package com.example.codepower2.problem;

import com.example.codepower2.entities.problem.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/problem")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @PostMapping("/")
    public void addProblem(@RequestBody Problem problem) {
        System.out.println("Problem: " +  problem);
        problemService.addProblem(problem);
    }
}