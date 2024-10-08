package com.f1diary.f1diary_back_end.Race.Repository;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {
    public Race findRaceByRaceId(Long raceId);

}
