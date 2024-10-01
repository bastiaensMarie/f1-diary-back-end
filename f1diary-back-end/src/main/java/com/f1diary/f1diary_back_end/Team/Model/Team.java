package com.f1diary.f1diary_back_end.Team.Model;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;

    private String teamName;

    private int totalPoints;

    @OneToMany(mappedBy = "team")
    private List<Racer> racers;

    @JsonIgnore
    @OneToMany(mappedBy = "pitStop")
    private List<Race> pitStop;

    @OneToMany(mappedBy = "team_id")
    private List<RaceResult> raceResults;

    public Team() {

    }

    public Team( String teamName, int totalPoints) {
        this.teamName = teamName;
        this.totalPoints = totalPoints;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Racer> getRacers() {
        return racers;
    }

    public void setRacers(List<Racer> racers) {
        this.racers = racers;
    }

    public List<Race> getPitStop() {
        return pitStop;
    }

    public void setPitStop(List<Race> pitStop) {
        this.pitStop = pitStop;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public void setRaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }
}
