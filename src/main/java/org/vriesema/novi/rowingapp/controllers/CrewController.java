package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.service.CrewService;
import org.vriesema.novi.rowingapp.service.ResultService;


@RestController
@RequestMapping("/api/users/crews")
public class CrewController {
    private final CrewService crewService;
    private final ResultService resultService;

    @Autowired
    public CrewController(CrewService crewService, ResultService resultService) {
        this.crewService = crewService;
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<Object> getCrews() {
        return ResponseEntity.ok().body(crewService.getCrews());
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getCrewById(@PathVariable("crewid") long crewId) {
        if (crewService.findByCrewId(crewId).isPresent()) {
            return ResponseEntity.ok().body(crewService.findByCrewId(crewId));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return ResponseEntity.noContent().build();
    }

    @GetMapping (value = "/results")
    public ResponseEntity<Object> getResults() {
        return ResponseEntity.ok().body(resultService.getResults());
    }

    // TODO results by crew ID
    // TODO add result POST
}
