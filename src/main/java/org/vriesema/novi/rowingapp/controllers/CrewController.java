package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vriesema.novi.rowingapp.controllers.dto.CrewDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.service.CrewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<CrewDto> dtos = new ArrayList<>();
        List<Crew> crewList = crewService.getCrews();
        for (Crew crew : crewList) {
            dtos.add(CrewDto.fromCrew(crew));
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getCrewById(@PathVariable("crewid") long crewId) {
        Optional<Crew> optionalCrew = crewService.findCrewId(crewId);
        if (optionalCrew.isPresent()) {
            CrewDto dto = CrewDto.fromCrew(optionalCrew.get());
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();
    }

}
