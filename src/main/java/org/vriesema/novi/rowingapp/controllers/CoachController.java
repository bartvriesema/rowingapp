package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.service.CoachService;

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
        return ResponseEntity.ok().body(coachService.getCoaches());
    }

    @GetMapping(value = "/clubcoaches")
    public ResponseEntity<Object> getClubCoaches() {
        return ResponseEntity.ok().body(coachService.getClubCoaches());
    }

    @PostMapping
    public ResponseEntity<Object> addCoach(@RequestBody Coach coach) {
        coachService.addCoach(coach);
        return ResponseEntity.noContent().build();
    }


}
