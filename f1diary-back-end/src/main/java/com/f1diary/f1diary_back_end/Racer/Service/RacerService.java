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

    @Autowired
    TeamRepository teamRepository;

    public RacerService() {

    }

    public List<Racer> getAllRacers() {
        return racerRepository.findAll();
    }

    public Racer addRacer(Racer racer, Long teamId) throws RacerServiceException{
        Team team = teamRepository.findTeamByTeamId(teamId);
        if (racer == null) {
            throw new RacerServiceException("Racer", "Cannot add empty racer");
        } else {
            racer.setTeam(team);
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


}
