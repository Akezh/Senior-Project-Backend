package com.example.codepower2.submission;

import com.example.codepower2.entities.submission.Submission;
import com.example.codepower2.entities.submission.SubmissionRepository;
import com.example.codepower2.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            @AuthenticationPrincipal User user) {
        return submissionRepository.findAllByUserIdAndProblemId(user.getId(), problemId);
    }

    @PostMapping("/")
    public void save(@RequestBody Submission submission,
                     @AuthenticationPrincipal User user) {
        submission.userId = user.getId();
        submissionRepository.save(submission);
    }
}
