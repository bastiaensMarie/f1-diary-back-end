package com.f1diary.f1diary_back_end.RaceResult.Model;

public class RaceResult {

    private Long raceResult_id;

    private Long racer_id;

    private Long race_id;

    private Long team_id;

    private int position;

    private int points;

    public RaceResult() {

    }

    public RaceResult(Long raceResult_id, Long racer_id, Long race_id, Long team_id, int position, int points) {
        this.raceResult_id = raceResult_id;
        this.racer_id = racer_id;
        this.race_id = race_id;
        this.team_id = team_id;
        this.position = position;
        this.points = points;
    }

    public Long getRaceResult_id() {
        return raceResult_id;
    }

    public void setRaceResult_id(Long raceResult_id) {
        this.raceResult_id = raceResult_id;
    }

    public Long getRacer_id() {
        return racer_id;
    }

    public void setRacer_id(Long racer_id) {
        this.racer_id = racer_id;
    }

    public Long getRace_id() {
        return race_id;
    }

    public void setRace_id(Long race_id) {
        this.race_id = race_id;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
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
