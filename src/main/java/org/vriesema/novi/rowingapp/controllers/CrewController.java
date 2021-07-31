package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.service.CrewService;


@RestController
@RequestMapping("/api/users/crews")
public class CrewController {
    private final CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping
    public ResponseEntity<Object> getCrews() {
        return ResponseEntity.ok().body(crewService.getCrews());
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getCrewById(@PathVariable("crewid") long crewId) {
        if (crewService.findCrewId(crewId).isPresent()) {
            return ResponseEntity.ok().body(crewService.findCrewId(crewId));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return ResponseEntity.noContent().build();
    }
}
