package com.f1diary.f1diary_back_end.Team.Model;

public class Team {

    private Long team_id;

    private String teamName;

    private int totalPoints;

    public Team() {

    }

    public Team(Long team_id, String teamName, int totalPoints) {
        this.team_id = team_id;
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
}
