package com.f1diary.f1diary_back_end;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Race.Repository.RaceRepository;
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
            if (teamRepository.findTeamByTeamName("testTeam").isEmpty()) {
                Team team = new Team();
                team.setTeamName("testTeam");
                team.setTotalPoints(0);
                teamRepository.save(team);
            }

            if (raceRepository.findRaceByRaceName("testRace").isEmpty()) {
                Race race = new Race();
                race.setRaceName("testRace");
                race.setLocation("test");
                race.setYear(2000);
                raceRepository.save(race);
            }

            if (racerRepository.findRacerByLastName("test").isEmpty()) {
                Racer racer = new Racer();
                racer.setFirstName("test");
                racer.setLastName("test");
                racer.setTotalPoints(0);
                racerRepository.save(racer);
            }

        };
    }
}
