package com.f1diary.f1diary_back_end.Racer.Model;

public class Racer {

    private Long racer_id;

    private String firstName;

    private String lastName;

    private Long team_id;

    private int totalPoints;

    public Racer() {

    }

    public Racer(Long racer_id, String firstName, String lastName, Long team_id, int totalPoints) {
        this.racer_id = racer_id;
        this. firstName = firstName;
        this.lastName = lastName;
        this.team_id = team_id;
        this.totalPoints = totalPoints;
    }

    public Long getRacer_id() {
        return racer_id;
    }

    public void setRacer_id(Long racer_id) {
        this.racer_id = racer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
