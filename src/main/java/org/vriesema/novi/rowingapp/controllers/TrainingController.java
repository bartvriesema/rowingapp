package org.vriesema.novi.rowingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;
import org.vriesema.novi.rowingapp.service.TrainingScheduleService;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;
import org.vriesema.novi.rowingapp.service.TrainingTypeService;

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
        return ResponseEntity.ok().body(trainingScheduleService.getTrainingSchedules());
    }

    @PostMapping
    public ResponseEntity<Object> addTrainingSchedule(@RequestBody TrainingSchedule trainingSchedule) {
        trainingScheduleService.addTrainingSchedule(trainingSchedule);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{crewid}")
    public ResponseEntity<Object> getTrainingScheduleByCrewId(@PathVariable("crewid") long crewId) {
        return ResponseEntity.ok().body(trainingScheduleService.getTrainingScheduleByCrewId(crewId));
    }

    @GetMapping(value = "/types")
    public ResponseEntity<Object> getTrainingTypes() {
        return ResponseEntity.ok().body(trainingTypeService.getTrainingTypes());
    }

    @PostMapping(value = "/types")
    public ResponseEntity<Object> addTrainingType(@RequestBody TrainingType trainingType) {
        trainingTypeService.addTrainingType(trainingType);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/sessions")
    public ResponseEntity<Object> getTrainingSessions() {
        return ResponseEntity.ok().body(trainingSessionService.getTrainingSessions());
    }

    @GetMapping(value = "/sessions/{crewid}")
    public ResponseEntity<Object> getTrainingSessionByCrewId(@PathVariable("crewid") long crewId) {
        return ResponseEntity.ok().body(trainingSessionService.getTrainingSessionByCrewId(crewId));
    }

    @PostMapping(value = "/sessions") // TODO return url to training session?
    public ResponseEntity<Object> addTrainingSession(@RequestBody TrainingSession trainingSession) {
        trainingSessionService.addTrainingSession(trainingSession);
        return ResponseEntity.noContent().build();
    }

}
