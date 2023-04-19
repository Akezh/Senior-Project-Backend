package com.example.codepower2.submission;

import com.example.codepower2.entities.submission.Submission;
import com.example.codepower2.entities.submission.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionRepository submissionRepository;

    @GetMapping("/problem/{problemId}")
    public List<Submission> get(
            @PathVariable Integer problemId,
            @RequestParam(name = "userId") Integer userId) {
        return submissionRepository.findAllByUserIdAndAndProblemId(userId, problemId);
    }

    @PostMapping("/")
    public void save(@RequestBody Submission submission) {
        submissionRepository.save(submission);
    }
}
