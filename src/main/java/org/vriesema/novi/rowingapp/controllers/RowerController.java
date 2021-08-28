package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vriesema.novi.rowingapp.controllers.dtos.HeartRateDto;
import org.vriesema.novi.rowingapp.controllers.dtos.RowerDto;
import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<RowerDto> rowerDtos = new ArrayList<>();
        List<Rower> rowerList = rowerService.getRowers();

        for (Rower rower : rowerList) {
            rowerDtos.add(RowerDto.fromRower(rower));
        }

        return ResponseEntity.ok().body(rowerDtos);
    }

    @GetMapping(value = "/crew/{crewid}")
    public ResponseEntity<Object> getRowersByCrewId(@PathVariable("crewid") long crewId) {
        List<Rower> rowerList = rowerService.findRowersByCrewId(crewId);

        if (rowerList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RowerDto> rowerDtos = new ArrayList<>();

        for (Rower rower : rowerList) {
            rowerDtos.add(RowerDto.fromRower(rower));
        }

        return ResponseEntity.ok().body(rowerDtos);
    }

    @PostMapping
    public ResponseEntity<Object> addRower(@RequestBody RowerDto rowerDto) {
        Long newRowerId = rowerService.addRower(rowerDto.toRower());

        URI rowerLink = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rowerid}").buildAndExpand(newRowerId).toUri();

        return ResponseEntity.created(rowerLink).build();
    }

    @GetMapping(value = "/{rowerid}")
    public ResponseEntity<Object> getRowerById(@PathVariable("rowerid") long rowerId) {
        Optional<Rower> rower = rowerService.findRowerById(rowerId);
        if (rower.isPresent()) {
            RowerDto rowerDto = RowerDto.fromRower(rower.get());
            return ResponseEntity.ok().body(rowerDto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/heartrate/{rowerid}")
    public ResponseEntity<Object> getHeartrateByRowerId(@PathVariable("rowerid") long rowerId) {
        List<HeartRate> heartRateList = rowerService.getHeartRateList(rowerId);
        List<HeartRateDto> heartRateDtos = new ArrayList<>();

        for (HeartRate heartRate : heartRateList) {
            heartRateDtos.add(HeartRateDto.fromHeartRate(heartRate));
        }

        return ResponseEntity.ok().body(heartRateDtos);
    }

    @PostMapping(value = "/heartrate/{rowerid}")
    public ResponseEntity<Object> addHeartRate(@PathVariable("rowerid") long rowerId, @RequestBody HeartRateDto heartRateDto) {
        return ResponseEntity.ok().body(rowerService.addHeartRate(rowerId, heartRateDto.toHeartRate()));

    }
}


