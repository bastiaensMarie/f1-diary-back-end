package com.f1diary.f1diary_back_end.Race.Controller;

import com.f1diary.f1diary_back_end.Race.Model.Race;
import com.f1diary.f1diary_back_end.Race.Service.RaceService;
import com.f1diary.f1diary_back_end.Race.Service.RaceServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/race")
public class RaceRestController {

    @Autowired
    private RaceService raceService;

    @GetMapping("/all")
    public List<Race> getAllRaces() {
        return raceService.getRaces();
    }

    @PostMapping("/add")
    public Race addRace(@RequestBody Race race) throws RaceServiceException {
        return raceService.addRace(race);
    }

    @DeleteMapping("/remove/{id}")
    public Race removeRace(@PathVariable Long race_id) throws RaceServiceException {
        return raceService.removeRace(race_id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ RaceServiceException.class })
    public Map<String, String> handleServiceException(RaceServiceException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getField(), ex.getMessage());
        return errors;
    }
}
