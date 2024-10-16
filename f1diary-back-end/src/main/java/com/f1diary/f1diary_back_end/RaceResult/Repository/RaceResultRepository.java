package com.f1diary.f1diary_back_end.RaceResult.Repository;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
    public RaceResult findRaceResultByRaceResultId(Long raceResultId);
    public List<RaceResult> findRaceResultsByRaceIdOrderByPosition(Race race);
}
