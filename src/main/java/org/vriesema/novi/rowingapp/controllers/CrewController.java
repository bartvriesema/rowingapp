package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.controllers.dtos.CrewDto;
import org.vriesema.novi.rowingapp.controllers.dtos.ResultDto;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Result;
import org.vriesema.novi.rowingapp.service.CrewService;
import org.vriesema.novi.rowingapp.service.ResultService;

import java.util.ArrayList;
import java.util.List;


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
        List<CrewDto> crewDtos = new ArrayList<>();
        List<Crew> crewList = crewService.getCrews();

        for (Crew crew : crewList) {
            crewDtos.add(CrewDto.fromCrew(crew));
        }

        return ResponseEntity.ok().body(crewDtos);
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getCrewById(@PathVariable("crewid") long crewId) {
        if (crewService.findByCrewId(crewId).isPresent()) {
            Crew crew = crewService.findByCrewId(crewId).get();
            CrewDto crewDto = CrewDto.fromCrew(crew);

            return ResponseEntity.ok().body(crewDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> addCrew(@RequestBody CrewDto crewDto) {

        crewService.addCrew(crewDto.toCrew());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/results")
    public ResponseEntity<Object> getResults() {
        List<ResultDto> resultDtos = new ArrayList<>();
        List<Result> resultList = resultService.getResults();

        for (Result result : resultList) {
            resultDtos.add(ResultDto.fromResult(result));
        }

        return ResponseEntity.ok().body(resultDtos);
    }

    @PostMapping(value = "/results")
    public ResponseEntity<Object> addResult(@RequestBody ResultDto resultDto) {
        resultService.addResult(resultDto.toResult());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/results/{crewid}")
    public ResponseEntity<Object> getResultByCrewId(@PathVariable("crewid") long crewId) {
        List<Result> resultList = resultService.getResultsByCrewId(crewId);

        if (resultList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ResultDto> resultDtos = new ArrayList<>();

        for (Result result : resultList) {
            resultDtos.add(ResultDto.fromResult(result));
        }

        return ResponseEntity.ok().body(resultDtos);

    }


}

