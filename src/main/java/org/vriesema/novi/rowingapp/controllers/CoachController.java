package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vriesema.novi.rowingapp.controllers.dtos.CoachDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.service.CoachService;

import java.net.URI;
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
        List<CoachDto> coachDtos = new ArrayList<>();
        List<Coach> coachList = coachService.getCoaches();

        for (Coach coach : coachList) {
            coachDtos.add(CoachDto.fromCoach(coach));
        }

        return ResponseEntity.ok().body(coachDtos);
    }

    @GetMapping(value = "/clubcoaches")
    public ResponseEntity<Object> getClubCoaches() {
        List<CoachDto> coachDtos = new ArrayList<>();
        List<Coach> coachList = coachService.getClubCoaches();

        for (Coach coach : coachList) {
            coachDtos.add(CoachDto.fromCoach(coach));
        }

        return ResponseEntity.ok().body(coachDtos);
    }

    @PostMapping
    public ResponseEntity<Object> addCoach(@RequestBody CoachDto coachDto) {
        Long newCoachId = coachService.addCoach(coachDto.toCoach());

        URI coachLink = ServletUriComponentsBuilder.fromCurrentRequest().path("/{coachid}").buildAndExpand(newCoachId).toUri();

        return ResponseEntity.created(coachLink).build();
    }

    @PutMapping(value = "/{coachid}")
    public ResponseEntity<Object> updateCoach(@PathVariable("coachid") long coachId, @RequestBody CoachDto coachDto) {
        coachDto.setCoachId(coachId);
        coachService.updateCoach(coachId, coachDto.toCoach());
        return ResponseEntity.noContent().build();
    }


}
