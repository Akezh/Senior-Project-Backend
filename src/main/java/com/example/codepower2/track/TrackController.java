package com.example.codepower2.track;

import com.example.codepower2.entities.common.ConfirmationResponse;
import com.example.codepower2.entities.submission.SubmissionRepository;
import com.example.codepower2.entities.trackproblem.TrackProblem;
import com.example.codepower2.entities.trackproblem.TrackProblemRepository;
import com.example.codepower2.entities.problem.Problem;
import com.example.codepower2.entities.track.Track;
import com.example.codepower2.entities.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/track")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    private final TrackProblemRepository trackProblemRepository;

    private final SubmissionRepository submissionRepository;

    @CrossOrigin
    @GetMapping()
    public List<Track> getTracks() {
        return trackService.getTracks();
    }

    @CrossOrigin
    @GetMapping("/{trackId}")
    public Track getTrackById(@PathVariable Integer trackId) {
        return trackService.getTrackById(trackId);
    }
    @CrossOrigin
    @PostMapping()
    public void addTrack(@RequestBody Track track) {
        trackService.addTrack(track);
    }

    @CrossOrigin
    @DeleteMapping("/{trackId}")
    public void deleteTrack(@PathVariable Integer trackId) {
        trackService.deleteTrack(trackId);
    }
    @CrossOrigin
    @GetMapping("/{trackId}/problems")
    public List<Problem> getTrackProblems(
            @PathVariable Integer trackId,
            @AuthenticationPrincipal User user) {
        return trackProblemRepository.findProblemsByTrackId(trackId).stream()
                .peek(problem ->
                        problem.setSolved(user != null && !submissionRepository.findAllByUserIdAndProblemIdAndVerdict(user.getId(), problem.getId(), "accepted").isEmpty())
                )
                .toList();
    }

    @CrossOrigin
    @PostMapping("/problem")
    public ResponseEntity<Object> addTrackProblem(@RequestBody TrackProblem trackProblem) {

        trackProblemRepository.save(trackProblem);

        ConfirmationResponse confirmationResponse = new ConfirmationResponse("Problem is added to the track successfully");

        return new ResponseEntity<>(confirmationResponse, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("{trackId}/problem/{problemId}/delete")
    @Transactional
    public ResponseEntity<Object> deleteTrackProblem(
            @PathVariable Integer trackId,
            @PathVariable Integer problemId) {

        trackProblemRepository.deleteAllByTrackIdAndProblemId(trackId, problemId);

        ConfirmationResponse confirmationResponse = new ConfirmationResponse("Problem is deleted from the track successfully");

        return new ResponseEntity<>(confirmationResponse, HttpStatus.OK);
    }
}