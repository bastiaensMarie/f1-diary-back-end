package com.f1diary.f1diary_back_end.Race.Model;

import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Team.Model.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raceId;

    private String raceName;

    private String location;

    private int year;

    @ManyToOne
    @JoinColumn(name = "dod")
    private Racer dodId;

    @ManyToOne
    @JoinColumn(name = "fastLap")
    private Racer fastLapId;

    @ManyToOne
    @JoinColumn(name = "pitStop")
    private Team pitStop;

    @OneToMany(mappedBy = "raceId")
    private List<RaceResult> raceResults;


    public Race() {

    }

    public Race( String raceName, String location, int year) {
        this.raceName = raceName;
        this.location = location;
        this.year = year;
    }


    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Racer getDodId() {
        return dodId;
    }

    public void setDodId(Racer dodId) {
        this.dodId = dodId;
    }

    public Racer getFastLapId() {
        return fastLapId;
    }

    public void setFastLap_id(Racer fastLapId) {
        this.fastLapId = fastLapId;
    }


    public Team getPitStop() {
        return pitStop;
    }

    public void setPitStop(Team pitStop) {
        this.pitStop = pitStop;
    }
}
