package com.f1diary.f1diary_back_end.Racer.Service;

import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Racer.Repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacerService {

    @Autowired
    RacerRepository racerRepository;

    public RacerService() {

    }

    public List<Racer> getAllRacers() {
        return racerRepository.findAllRacers();
    }

    public Racer addRacer(Racer racer) throws RacerServiceException{
        if (racer == null) {
            throw new RacerServiceException("Racer", "Cannot add empty racer");
        } else {
            Racer racer1 = racerRepository.save(racer);
            return racer1;
        }
    }

    public Racer removeRacer(Long racer_id) throws RacerServiceException {
        Racer toRemove = racerRepository.findRacerByRacerId(racer_id);
        if (toRemove == null) {
            throw new RacerServiceException("Racer", "Cannot remove empty racer");
        } else {
            racerRepository.delete(toRemove);
            return toRemove;
        }
    }
}
