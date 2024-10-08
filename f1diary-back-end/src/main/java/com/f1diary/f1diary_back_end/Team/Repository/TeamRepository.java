package com.f1diary.f1diary_back_end.Team.Repository;

import com.f1diary.f1diary_back_end.Team.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    public Team findTeamByTeamId(Long teamId);
}
