package com.example.codepower2.entities.trackproblem;

import com.example.codepower2.entities.problem.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackProblemRepository extends JpaRepository<TrackProblem, Integer> {

    @Query(value = "SELECT p FROM Problem p JOIN TrackProblem t ON p.id = t.problemId WHERE t.trackId = ?1")
    List<Problem> findProblemsByTrackId(Integer trackId);
}
