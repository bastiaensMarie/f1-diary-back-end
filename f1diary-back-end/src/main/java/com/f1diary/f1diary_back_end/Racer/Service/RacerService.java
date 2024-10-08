package com.f1diary.f1diary_back_end.Racer.Service;

import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Racer.Repository.RacerRepository;
import com.f1diary.f1diary_back_end.Team.Model.Team;
import com.f1diary.f1diary_back_end.Team.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacerService {

    @Autowired
    RacerRepository racerRepository;
    TeamRepository teamRepository;

    public RacerService() {

    }

    public List<Racer> getAllRacers() {
        return racerRepository.findAll();
    }

    public Racer addRacer(Racer racer) throws RacerServiceException{
        if (racer == null) {
            throw new RacerServiceException("Racer", "Cannot add empty racer");
        } else {
            Racer racer1 = racerRepository.save(racer);
            return racer1;
        }
    }

    public Racer removeRacer(Long racerId) throws RacerServiceException {
        Racer toRemove = racerRepository.findRacerByRacerId(racerId);
        if (toRemove == null) {
            throw new RacerServiceException("Racer", "Cannot remove empty racer");
        } else {
            racerRepository.delete(toRemove);
            return toRemove;
        }
    }

    public Racer addTeamToRacer(Long teamId, Long racerId) throws RacerServiceException {
        Team toAdd = teamRepository.findTeamByTeamId(teamId);
        Racer racer = racerRepository.findRacerByRacerId(racerId);
        if (toAdd == null) {
            throw new RacerServiceException("Racer", "Cannot add to empty team");
        } else if (racer == null){
            throw new RacerServiceException("Racer", "Cannot add empty racer to team");
        } else {
            racer.setTeam(toAdd);
            return racer;
        }
    }
}
