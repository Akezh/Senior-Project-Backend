package com.example.codepower2.problem;

import com.example.codepower2.entities.problem.Problem;
import com.example.codepower2.entities.problem.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;

    public Problem getProblemDetails(int problemId) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new IllegalStateException("Client with id " + problemId + " does not exist"));

        return problem;
    }

    public void addProblem(Problem problem) {
        if (problem.getTitle() == null
                || problem.getDescription() == null
                || problem.getCategory() == null
                || problem.getDifficulty() == null) {
            throw new IllegalStateException("Some important fields of the problem are empty");
        }

        problemRepository.save(problem);
    }
}
