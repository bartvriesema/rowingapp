package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.model.rowingclub.Heartrate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.service.RowerService;

@RestController
@RequestMapping("/api/users/rowers")
public class RowerController {

    private final RowerService rowerService;

    @Autowired
    public RowerController(RowerService rowerService) {
        this.rowerService = rowerService;
    }

    @GetMapping
    public ResponseEntity<Object> getRowers() {
        return ResponseEntity.ok().body(rowerService.getRowers());
    }

    @GetMapping(value = "/crew/{crewid}")
    public ResponseEntity<Object> getRowerByCrewId(@PathVariable("crewid") long crewId) {
        return ResponseEntity.ok().body(rowerService.findRowerByCrewId(crewId));
    }

    @PostMapping
    public ResponseEntity<Object> addRower(@RequestBody Rower rower) {
        rowerService.addRower(rower);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{rowerid}")
    public ResponseEntity<Object> getRowerById(@PathVariable("rowerid") long rowerId) {
        return ResponseEntity.ok().body(rowerService.findRowerById(rowerId));
    }

    @GetMapping(value = "/heartrate/{rowerid}")
    public ResponseEntity<Object> getHeartrateByRowerId(@PathVariable("rowerid") long rowerId) {
        return ResponseEntity.ok().body(rowerService.getHeartrateList(rowerId));
    }

    @PostMapping(value = "/heartrate/{rowerid}")
    public ResponseEntity<Object> addHeartRate(@PathVariable("rowerid") long rowerId, @RequestBody Heartrate heartRate) {
        rowerService.addHeartrate(rowerId, heartRate);
        return ResponseEntity.noContent().build();
    }
}


