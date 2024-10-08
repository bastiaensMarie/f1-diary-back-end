package com.f1diary.f1diary_back_end.Racer.Model;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.Team.Model.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Racer")
public class Racer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long racerId;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @OneToMany(mappedBy = "dodId")
    private List<Race> dod;

    @OneToMany(mappedBy = "fastLapId")
    private List<Race> fastLap;

    @OneToMany(mappedBy = "racerId", orphanRemoval = true)
    private List<RaceResult> raceResults;



    private int totalPoints;

    public Racer() {

    }

    public Racer( String firstName, String lastName, int totalPoints) {
        this. firstName = firstName;
        this.lastName = lastName;
        this.totalPoints = totalPoints;
    }

    public Long getRacerId() {
        return racerId;
    }

    public void setRacerId(Long racerId) {
        this.racerId = racerId;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Race> getDod() {
        return dod;
    }

    public void setDod(List<Race> dod) {
        this.dod = dod;
    }

    public List<Race> getFastLap() {
        return fastLap;
    }

    public void setFastLap(List<Race> fastLap) {
        this.fastLap = fastLap;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public void setRaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }
}
