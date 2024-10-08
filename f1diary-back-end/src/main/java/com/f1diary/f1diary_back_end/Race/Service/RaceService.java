package com.f1diary.f1diary_back_end.Race.Service;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Race.Repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    public RaceRepository  raceRepository;

    public RaceService() {

    }

    public List<Race> getRaces() {
        return raceRepository.findAll();

    }

    public Race addRace(Race race) throws RaceServiceException{
        if (race == null) {
            throw new RaceServiceException("Race", "Cannot add an empty race");
        } else {
            Race race1 = raceRepository.save(race);
            return race1;
        }
    }

    public Race removeRace(Long raceId) throws RaceServiceException{
        Race toRemove = raceRepository.findRaceByRaceId(raceId);
        if (toRemove == null) {
            throw new RaceServiceException("Race", "Cannot remove race that does not exist");
        } else {
            raceRepository.delete(toRemove);
            return toRemove;
        }
    }
}
