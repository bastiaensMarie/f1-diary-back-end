package com.f1diary.f1diary_back_end.Race.Model;

import jakarta.persistence.*;


public class Race {

    private Long race_id;

    private String raceName;

    private String location;

    private int year;

    private Long dod_id;

    private Long fastLap_id;

    private Long pitStop_id;


    public Race() {

    }

    public Race(Long race_id, String raceName, String location, int year, Long dod_id, Long fastLap_id, Long pitStop_id) {
        this.race_id = race_id;
        this.raceName = raceName;
        this.location = location;
        this.year = year;
        this.dod_id = dod_id;
        this.fastLap_id = fastLap_id;
        this.pitStop_id = pitStop_id;
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

    public Long getDod_id() {
        return dod_id;
    }

    public void setDod_id(Long dod_id) {
        this.dod_id = dod_id;
    }

    public Long getFastLap_id() {
        return fastLap_id;
    }

    public void setFastLap_id(Long fastLap_id) {
        this.fastLap_id = fastLap_id;
    }

    public Long getPitStop_id() {
        return pitStop_id;
    }

    public void setPitStop_id(Long pitStop_id) {
        this.pitStop_id = pitStop_id;
    }
}
