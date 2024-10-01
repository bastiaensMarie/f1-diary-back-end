package com.f1diary.f1diary_back_end.RaceResult.Model;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Team.Model.Team;

import jakarta.persistence.*;

@Entity
@Table(name="RaceResult")
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raceResult_id;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race_id;

    @ManyToOne
    @JoinColumn(name = "racer_id")
    private Racer racer_id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team_id;

    private int position;

    private int points;

    public RaceResult() {

    }

    public RaceResult( int position, int points) {
        this.position = position;
        this.points = points;
    }

    public Long getRaceResult_id() {
        return raceResult_id;
    }

    public void setRaceResult_id(Long raceResult_id) {
        this.raceResult_id = raceResult_id;
    }

    public Racer getRacer_id() {
        return racer_id;
    }

    public void setRacer_id(Racer racer_id) {
        this.racer_id = racer_id;
    }

    public Race getRace_id() {
        return race_id;
    }

    public void setRace_id(Race race_id) {
        this.race_id = race_id;
    }

    public Team getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Team team_id) {
        this.team_id = team_id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
