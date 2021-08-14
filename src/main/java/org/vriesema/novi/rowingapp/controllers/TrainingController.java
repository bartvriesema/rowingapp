package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingScheduleDto;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingSessionDto;
import org.vriesema.novi.rowingapp.controllers.dtos.TrainingTypeDto;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;
import org.vriesema.novi.rowingapp.service.TrainingScheduleService;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;
import org.vriesema.novi.rowingapp.service.TrainingTypeService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/training")
public class TrainingController {

    private final TrainingScheduleService trainingScheduleService;
    private final TrainingTypeService trainingTypeService;
    private final TrainingSessionService trainingSessionService;

    @Autowired
    public TrainingController(TrainingScheduleService trainingScheduleService, TrainingTypeService trainingTypeService, TrainingSessionService trainingSessionService) {
        this.trainingScheduleService = trainingScheduleService;
        this.trainingTypeService = trainingTypeService;
        this.trainingSessionService = trainingSessionService;
    }

    @GetMapping
    public ResponseEntity<Object> getTrainingSchedules() {
        List<TrainingSchedule> trainingScheduleList = trainingScheduleService.getTrainingSchedules();
        List<TrainingScheduleDto> trainingScheduleDtos = new ArrayList<>();

        for (TrainingSchedule trainingSchedule : trainingScheduleList) {
            trainingScheduleDtos.add(TrainingScheduleDto.fromTrainingSchedule(trainingSchedule));
        }

        return ResponseEntity.ok().body(trainingScheduleDtos);
    }

    @PostMapping
    public ResponseEntity<Object> addTrainingSchedule(@RequestBody TrainingScheduleDto trainingScheduleDto) {
        trainingScheduleService.addTrainingSchedule(trainingScheduleDto.toTrainingSchedule());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getTrainingScheduleByCrewId(@PathVariable("crewid") long crewId) {
        if (trainingScheduleService.getTrainingScheduleByCrewId(crewId).isPresent()) {
            TrainingSchedule trainingSchedule = trainingScheduleService.getTrainingScheduleByCrewId(crewId).get();
            TrainingScheduleDto trainingScheduleDto = TrainingScheduleDto.fromTrainingSchedule(trainingSchedule);
            return ResponseEntity.ok().body(trainingScheduleDto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/types")
    public ResponseEntity<Object> getTrainingTypes() {
        List<TrainingType> trainingTypeList = trainingTypeService.getTrainingTypes();
        List<TrainingTypeDto> trainingTypeDtos = new ArrayList<>();

        for (TrainingType trainingType : trainingTypeList) {
            trainingTypeDtos.add(TrainingTypeDto.fromTrainingType(trainingType));
        }

        return ResponseEntity.ok().body(trainingTypeDtos);
    }

    @PostMapping(value = "/types")
    public ResponseEntity<Object> addTrainingType(@RequestBody TrainingTypeDto trainingTypeDto) {
        trainingTypeService.addTrainingType(trainingTypeDto.toTrainingType());
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/sessions")
    public ResponseEntity<Object> getTrainingSessions() {
        List<TrainingSession> trainingSessionList = trainingSessionService.getTrainingSessions();
        List<TrainingSessionDto> trainingSessionDtos = new ArrayList<>();

        for (TrainingSession trainingSession : trainingSessionList) {
            trainingSessionDtos.add(TrainingSessionDto.fromTrainingSession(trainingSession));
        }

        return ResponseEntity.ok().body(trainingSessionDtos);
    }

    @GetMapping(value = "/sessions/crew/{crewid}")
    public ResponseEntity<Object> getTrainingSessionsByCrewId(@PathVariable("crewid") Long crewId) {
        List<TrainingSession> trainingSessionList = trainingSessionService.getTrainingSessionsByCrewId(crewId);
        List<TrainingSessionDto> trainingSessionDtos = new ArrayList<>();

        for (TrainingSession trainingSession : trainingSessionList) {
            trainingSessionDtos.add(TrainingSessionDto.fromTrainingSession(trainingSession));
        }

        return ResponseEntity.ok().body(trainingSessionDtos);
    }

    @GetMapping(value = "/sessions/{sessionid}")
    public ResponseEntity<Object> getTrainingSessionById(@PathVariable("sessionid") Long trainingSessionId) {

        if (trainingSessionService.getTrainingSessionById(trainingSessionId).isPresent()) {
            TrainingSession trainingSession = trainingSessionService.getTrainingSessionById(trainingSessionId).get();
            TrainingSessionDto trainingSessionDto = TrainingSessionDto.fromTrainingSession(trainingSession);
            return ResponseEntity.ok().body(trainingSessionDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/sessions")
    public ResponseEntity<Object> addTrainingSession(@RequestBody TrainingSessionDto trainingSessionDto) {
        Long newSessionId = trainingSessionService.addTrainingSession(trainingSessionDto.toTrainingSession());

        URI sessionLink = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sessionId}").buildAndExpand(newSessionId).toUri();

        return ResponseEntity.created(sessionLink).build();
    }

    @PutMapping(value = "/sessions/{sessionid}")
    public ResponseEntity<Object> updateTrainingSession(@PathVariable("sessionid") Long trainingSessionId,
                                                        @RequestBody TrainingSessionDto trainingSessionDto) {
        trainingSessionDto.setTrainingSessionId(trainingSessionId);

        trainingSessionService.updateTrainingSession(trainingSessionId, trainingSessionDto.toTrainingSession());

        return ResponseEntity.noContent().build();
    }

}
