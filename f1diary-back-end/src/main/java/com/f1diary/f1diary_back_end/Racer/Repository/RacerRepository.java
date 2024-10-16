package com.f1diary.f1diary_back_end.Racer.Repository;

import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RacerRepository extends JpaRepository<Racer, Long> {
    public Racer findRacerByRacerId(Long racerId);
    public List<Racer> findAllByOrderByTotalPointsDesc();
}
