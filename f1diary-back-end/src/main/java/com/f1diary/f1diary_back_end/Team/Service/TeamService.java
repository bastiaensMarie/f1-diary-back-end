package com.f1diary.f1diary_back_end.Team.Service;

import com.f1diary.f1diary_back_end.Team.Model.Team;
import com.f1diary.f1diary_back_end.Team.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamService () {

    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addTeam(Team team) throws TeamServiceException {
        if (team == null) {
            throw new TeamServiceException("Team", "Cannot add empty team");
        } else {
            return teamRepository.save(team);
        }
    }

    public Team removeTeam(Long teamId) throws TeamServiceException {
        Team toRemove = teamRepository.findTeamByTeamId(teamId);
        if (toRemove == null) {
            throw new TeamServiceException("Team", "Cannot remove empty team");
        } else {
            teamRepository.delete(toRemove);
            return toRemove;
        }
    }

    public List<Team> getAllTeamsSortedByTotalPoints() {
        return teamRepository.findAllByOrderByTotalPointsDesc();

    }
}
