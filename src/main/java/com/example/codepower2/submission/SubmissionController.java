package com.example.codepower2.submission;

import com.example.codepower2.entities.submission.Submission;
import com.example.codepower2.entities.submission.SubmissionRepository;
import com.example.codepower2.entities.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    @PostMapping()
    public Submission save(@RequestBody Submission submission,
                     @AuthenticationPrincipal User user) throws URISyntaxException, IOException, InterruptedException {
        submission.userId = user.getId();
        if (submission.verdict == null) {
            submission.verdict = "In queue";
        }
        if (submission.date == null) {
            submission.date = new Date();
        }

        submission = submissionRepository.save(submission);

        // Sending submission to judge system.
        String TARGET_URL = "http://oj:8000/evaluate/";

        URI targetURI = new URI(TARGET_URL);

        String postBody = String.format("{\"submissionId\": %s}", submission.id);

        System.out.println("Sending json body: " + postBody);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(targetURI)
                .POST(HttpRequest.BodyPublishers.ofString(postBody))
                .header("Content-Type", "application/json")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Judge system returned status code = " + response.statusCode());
        }

        return submission;
    }
}
