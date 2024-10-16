package com.f1diary.f1diary_back_end.RaceResult.Controller;


import com.f1diary.f1diary_back_end.RaceResult.Model.RaceResult;
import com.f1diary.f1diary_back_end.RaceResult.Service.RaceResultService;
import com.f1diary.f1diary_back_end.RaceResult.Service.RaceResultServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/raceresult")
public class RaceResultRestController {
    @Autowired
    RaceResultService raceResultService;

    @GetMapping("/all")
    public List<RaceResult> getAllRaceResults() {
        return raceResultService.getAllRaceResults();
    }

    @PostMapping("/add/{racerId}/{teamId}/{raceId}")
    public RaceResult addRaceResult(@RequestBody RaceResult raceResult, @PathVariable Long racerId, @PathVariable Long teamId, @PathVariable Long raceId) throws RaceResultServiceException {
        return raceResultService.addRaceResult(raceResult, teamId, racerId, raceId);
    }

    @DeleteMapping("/remove/{id}")
    public RaceResult removeRaceResult(@PathVariable Long raceResultId) throws RaceResultServiceException {
        return raceResultService.removeRaceResult(raceResultId);
    }

    @GetMapping("/finish/{raceId}")
    public List<RaceResult> getFinishPosition(@PathVariable Long raceId) {
        return raceResultService.getFinishingPositionForCertainRace(raceId);
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
    @ExceptionHandler({ RaceResultServiceException.class })
    public Map<String, String> handleServiceException(RaceResultServiceException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getField(), ex.getMessage());
        return errors;
    }
}
