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
    private Long raceResultId;

    @ManyToOne
    @JoinColumn(name = "raceId")
    private Race raceId;

    @ManyToOne
    @JoinColumn(name = "racerId")
    private Racer racerId;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team teamId;

    private int position;

    private int points;

    public RaceResult() {

    }

    public RaceResult( int position, int points) {
        this.position = position;
        this.points = points;
    }

    public Long getRaceResultId() {
        return raceResultId;
    }

    public void setRaceResultId(Long raceResultId) {
        this.raceResultId = raceResultId;
    }

    public Racer getRacerId() {
        return racerId;
    }

    public void setRacerId(Racer racerId) {
        this.racerId = racerId;
    }

    public Race getRaceId() {
        return raceId;
    }

    public void setRaceId(Race raceId) {
        this.raceId = raceId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
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
