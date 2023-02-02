package com.example.codepower2.track;

import com.example.codepower2.entities.track.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/track")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

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
}