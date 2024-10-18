package com.f1diary.f1diary_back_end;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Race.Repository.RaceRepository;
import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.RaceResult.Repository.RaceResultRepository;
import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Racer.Repository.RacerRepository;
import com.f1diary.f1diary_back_end.Team.Model.Team;
import com.f1diary.f1diary_back_end.Team.Repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseSeeder {

    @Bean
    CommandLineRunner initDataBase(TeamRepository teamRepository, RaceRepository raceRepository, RacerRepository racerRepository, RaceResultRepository raceResultRepository) {
        return args -> {
            Team team = new Team();
            if (teamRepository.findTeamByTeamName("testTeam").isEmpty()) {
                team.setTeamName("testTeam");
                team.setTotalPoints(0);
                teamRepository.save(team);
            }

            Race race = new Race();
            if (raceRepository.findRaceByRaceName("testRace").isEmpty()) {
                race.setRaceName("testRace");
                race.setLocation("test");
                race.setYear(2000);
                raceRepository.save(race);
            }

            Racer racer = new Racer();
            if (racerRepository.findRacerByLastName("test").isEmpty()) {
                racer.setFirstName("test");
                racer.setLastName("test");
                racer.setTotalPoints(0);
                racer.setTeam(team);
                racerRepository.save(racer);
            }

            RaceResult raceResult = new RaceResult();
            raceResult.setRaceId(race);
            raceResult.setTeamId(team);
            raceResult.setRacerId(racer);
            raceResult.setPosition(1);
            raceResult.setPoints(25);
            raceResultRepository.save(raceResult);

        };
    }
}
