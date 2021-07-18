package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vriesema.novi.rowingapp.service.CrewService;

/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

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

        return ResponseEntity.ok().body(crewService.findCrewId(crewId));

    }

}
