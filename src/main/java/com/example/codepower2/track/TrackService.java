package com.example.codepower2.track;

import com.example.codepower2.entities.track.Track;
import com.example.codepower2.entities.track.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public List<Track> getTracks() {
        List<Track> tracks = trackRepository.getTracks()
                .orElseThrow(() -> new IllegalStateException("Tracks do not exist"));

        return tracks;
    }

    public Track getTrackById(Integer trackId) {
        Track track = trackRepository.findTrackById(trackId)
                .orElseThrow(() -> new IllegalStateException("Track with id " + trackId + " does not exist"));

        return track;
    }

    public void addTrack(Track track) {
        if (track.getTitle() == null
                || track.getDescription() == null
                || track.getCategory() == null) {
            throw new IllegalStateException("Some important fields of the track are empty");
        }

        trackRepository.save(track);
    }
}
