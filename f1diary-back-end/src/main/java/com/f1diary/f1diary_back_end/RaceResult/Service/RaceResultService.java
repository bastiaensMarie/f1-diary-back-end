package com.f1diary.f1diary_back_end.RaceResult.Service;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.RaceResult.Repository.RaceResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceResultService {

    @Autowired
    RaceResultRepository raceResultRepository;

    public RaceResultService () {

    }

    public List<RaceResult> getAllRaceResults() {
        return raceResultRepository.findAllRaceResults();
    }

    public RaceResult addRaceResult(RaceResult raceResult) throws RaceResultServiceException {
        if (raceResult == null) {
            throw new RaceResultServiceException("RaceResult", "Cannot add empty raceresult");
        } else {
            return raceResultRepository.save(raceResult);
        }
    }

    public RaceResult removeRaceResult(Long raceResult_id) throws RaceResultServiceException {
        RaceResult toRemove = raceResultRepository.findRaceResultByRaceResultId(raceResult_id);
        if (toRemove == null) {
            throw new RaceResultServiceException("RaceResult", "Cannot remove empty raceresult");
        } else {
            raceResultRepository.delete(toRemove);
            return toRemove;
        }
    }
}
