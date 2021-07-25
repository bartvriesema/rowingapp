package org.vriesema.novi.rowingapp.controllers;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/{crew}")
    public ResponseEntity<Object> getTrainingScheduleByCrewId(@PathVariable("crew") long crewId) {
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


}
