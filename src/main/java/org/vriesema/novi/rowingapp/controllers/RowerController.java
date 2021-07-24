package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.controllers.dto.RowerDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.util.ArrayList;
import java.util.List;

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
//        List<RowerDto> dtos = new ArrayList<>();
//        List<Rower> rowerList = rowerService.getRowers();
//
//        for (Rower rower : rowerList) {
//            dtos.add(RowerDto.fromRower(rower));
//        }
//
//        return ResponseEntity.ok().body(dtos);
        return ResponseEntity.ok().body(rowerService.getRowers());
    }

    @GetMapping(value = "/{crew}")
    public ResponseEntity<Object> getRowerByCrewId(@PathVariable("crew") long crewId) {

        return ResponseEntity.ok().body(rowerService.findRowerByCrewId(crewId));

    }

    @PostMapping
    public ResponseEntity<Object> addRower(@RequestBody Rower rower) {
        rowerService.addRower(rower);
        return ResponseEntity.noContent().build();
    }
}


