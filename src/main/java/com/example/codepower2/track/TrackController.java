package com.example.codepower2.track;

import com.example.codepower2.entities.common.ConfirmationResponse;
import com.example.codepower2.entities.trackproblem.TrackProblem;
import com.example.codepower2.entities.trackproblem.TrackProblemRepository;
import com.example.codepower2.entities.problem.Problem;
import com.example.codepower2.entities.track.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/track")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    private final TrackProblemRepository trackProblemRepository;

    @GetMapping()
    public List<Track> getTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{trackId}")
    public Track getTrackById(@PathVariable Integer trackId) {
        return trackService.getTrackById(trackId);
    }

    @PostMapping("/")
    public void addTrack(@RequestBody Track track) {
        trackService.addTrack(track);
    }

    @GetMapping("/{trackId}/problems")
    public List<Problem> getTrackProblems(@PathVariable Integer trackId) {
        return trackProblemRepository.findProblemsByTrackId(trackId);
    }

    @PostMapping("/problem")
    public ResponseEntity<Object> addTrackProblem(@RequestBody TrackProblem trackProblem) {

        trackProblemRepository.save(trackProblem);

        ConfirmationResponse confirmationResponse = new ConfirmationResponse("Problem is added to the track successfully");

        return new ResponseEntity<>(confirmationResponse, HttpStatus.OK);
    }
}