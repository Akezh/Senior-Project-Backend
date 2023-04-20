package com.example.codepower2.entities.track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("SELECT t FROM Track t")
    Optional<List<Track>> getTracks();
    @Query("SELECT t FROM Track t WHERE t.id = ?1")
    Optional<Track> findTrackById(Integer id);

    void deleteById(Integer trackId);
}