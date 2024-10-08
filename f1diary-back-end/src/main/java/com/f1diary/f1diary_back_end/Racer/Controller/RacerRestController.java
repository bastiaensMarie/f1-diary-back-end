package com.f1diary.f1diary_back_end.Racer.Controller;

import com.f1diary.f1diary_back_end.Racer.Model.Racer;
import com.f1diary.f1diary_back_end.Racer.Service.RacerService;
import com.f1diary.f1diary_back_end.Racer.Service.RacerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/racer")
public class RacerRestController {
    @Autowired
    RacerService racerService;

    @GetMapping("/all")
    public List<Racer> getAllRacers() {
        return racerService.getAllRacers();
    }

    @PostMapping("/add")
    public Racer addRacer(@RequestBody Racer racer) throws RacerServiceException {
        return racerService.addRacer(racer);
    }

    @DeleteMapping("/remove/{id}")
    public Racer removeRacer(@PathVariable Long racerId) throws RacerServiceException {
        return racerService.removeRacer(racerId);
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
    @ExceptionHandler({ RacerServiceException.class })
    public Map<String, String> handleServiceException(RacerServiceException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getField(), ex.getMessage());
        return errors;
    }

}
