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
    private Long race_id;

    private String raceName;

    private String location;

    private int year;

    @ManyToOne
    @JoinColumn(name = "dod")
    private Racer dod_id;

    @ManyToOne
    @JoinColumn(name = "fastLap")
    private Racer fastLap_id;

    @ManyToOne
    @JoinColumn(name = "pitStop")
    private Team pitStop;

    @OneToMany(mappedBy = "race_id")
    private List<RaceResult> raceResults;


    public Race() {

    }

    public Race( String raceName, String location, int year) {
        this.raceName = raceName;
        this.location = location;
        this.year = year;
    }


    public Long getRace_id() {
        return race_id;
    }

    public void setRace_id(Long race_id) {
        this.race_id = race_id;
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

    public Racer getDod_id() {
        return dod_id;
    }

    public void setDod_id(Racer dod_id) {
        this.dod_id = dod_id;
    }

    public Racer getFastLap_id() {
        return fastLap_id;
    }

    public void setFastLap_id(Racer fastLap_id) {
        this.fastLap_id = fastLap_id;
    }


    public Team getPitStop() {
        return pitStop;
    }

    public void setPitStop(Team pitStop) {
        this.pitStop = pitStop;
    }
}
