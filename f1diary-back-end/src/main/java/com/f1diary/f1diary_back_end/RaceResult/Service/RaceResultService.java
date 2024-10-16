package com.f1diary.f1diary_back_end.RaceResult.Service;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Race.Repository.RaceRepository;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.RaceResult.Repository.RaceResultRepository;
import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Racer.Repository.RacerRepository;
import com.f1diary.f1diary_back_end.Team.Model.Team;
import com.f1diary.f1diary_back_end.Team.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceResultService {

    @Autowired
    RaceResultRepository raceResultRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RacerRepository racerRepository;

    @Autowired
    RaceRepository raceRepository;

    public RaceResultService () {

    }

    public List<RaceResult> getAllRaceResults() {
        return raceResultRepository.findAll();
    }

    public RaceResult addRaceResult(RaceResult raceResult, Long teamId, Long racerId, Long raceId) throws RaceResultServiceException {
        Team team = teamRepository.findTeamByTeamId(teamId);
        Racer racer = racerRepository.findRacerByRacerId(racerId);
        Race race = raceRepository.findRaceByRaceId(raceId);
        if (raceResult == null) {
            throw new RaceResultServiceException("RaceResult", "Cannot add empty raceresult");
        } else {
            int points = raceResult.getPoints();
            team.setTotalPoints(team.getTotalPoints() + points);
            racer.setTotalPoints(racer.getTotalPoints() + points);
            raceResult.setTeamId(team);
            raceResult.setRacerId(racer);
            raceResult.setRaceId(race);
            RaceResult raceResult1 = raceResultRepository.save(raceResult);
            return raceResult1;
        }
    }

    public RaceResult removeRaceResult(Long raceResultId) throws RaceResultServiceException {
        RaceResult toRemove = raceResultRepository.findRaceResultByRaceResultId(raceResultId);
        if (toRemove == null) {
            throw new RaceResultServiceException("RaceResult", "Cannot remove empty raceresult");
        } else {
            raceResultRepository.delete(toRemove);
            return toRemove;
        }
    }

    public List<RaceResult> getFinishingPositionForCertainRace (Long raceId) {
        Race race = raceRepository.findRaceByRaceId(raceId);
        return raceResultRepository.findRaceResultsByRaceIdOrderByPosition(race);
    }
}
