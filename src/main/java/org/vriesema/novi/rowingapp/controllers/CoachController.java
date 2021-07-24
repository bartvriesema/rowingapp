package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vriesema.novi.rowingapp.controllers.dto.CoachDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.service.CoachService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/coaches")
public class CoachController {
    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }


    @GetMapping
    public ResponseEntity<Object> getCoaches() {
        List<CoachDto> dtos = new ArrayList<>();
        List<Coach> coachList = coachService.getCoaches();
        for (Coach coach : coachList) {
            dtos.add(CoachDto.fromCoach(coach));
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/clubcoaches")
    public ResponseEntity<Object> getClubCoaches() {
        List<CoachDto> dtos = new ArrayList<>();
        List<Coach> coachList = coachService.getClubCoaches();
        for (Coach coach : coachList) {
            dtos.add(CoachDto.fromCoach(coach));
        }
        return ResponseEntity.ok().body(dtos);

    }
}
