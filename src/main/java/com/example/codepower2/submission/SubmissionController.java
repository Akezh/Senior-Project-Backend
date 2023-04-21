package com.example.codepower2.submission;

import com.example.codepower2.entities.submission.Submission;
import com.example.codepower2.entities.submission.SubmissionRepository;
import com.example.codepower2.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionRepository submissionRepository;

    @CrossOrigin
    @GetMapping("/problem/{problemId}")
    public List<Submission> get(
            @PathVariable Integer problemId,
            @AuthenticationPrincipal User user) {
        return submissionRepository.findAllByUserIdAndProblemId(user.getId(), problemId);
    }

    @CrossOrigin
    @PostMapping("/")
    public Submission save(@RequestBody Submission submission,
                     @AuthenticationPrincipal User user) {
        submission.userId = user.getId();
        if (submission.verdict == null) {
            submission.verdict = "testing";
        }
        if (submission.date == null) {
            submission.date = new Date();
        }
        return submissionRepository.save(submission);
    }
}
