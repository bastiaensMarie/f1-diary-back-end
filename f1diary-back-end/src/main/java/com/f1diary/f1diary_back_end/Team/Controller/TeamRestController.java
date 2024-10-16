package com.f1diary.f1diary_back_end.Team.Controller;

import com.f1diary.f1diary_back_end.Team.Model.Team;
import com.f1diary.f1diary_back_end.Team.Service.TeamService;
import com.f1diary.f1diary_back_end.Team.Service.TeamServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/team")
public class TeamRestController {

    @Autowired
    TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/add")
    public Team addTeam(@RequestBody Team team) throws TeamServiceException {
        return teamService.addTeam(team);
    }

    @DeleteMapping("/remove/{id}")
    public Team removeTeam(@PathVariable Long teamId) throws TeamServiceException {
        return teamService.removeTeam(teamId);
    }

    @GetMapping("/wcc")
    public List<Team> getAllTeamsSortedByTotalPoints() {
        return teamService.getAllTeamsSortedByTotalPoints();
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
    @ExceptionHandler({ TeamServiceException.class })
    public Map<String, String> handleServiceException(TeamServiceException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getField(), ex.getMessage());
        return errors;
    }
}
