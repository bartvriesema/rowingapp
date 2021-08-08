package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.repository.TrainingScheduleRepository;
import org.vriesema.novi.rowingapp.service.TrainingScheduleService;

@Service
public class TrainingScheduleServiceImpl implements TrainingScheduleService {

    private final TrainingScheduleRepository trainingScheduleRepository;

    @Autowired
    public TrainingScheduleServiceImpl(TrainingScheduleRepository repository) {
        this.trainingScheduleRepository = repository;
    }

    @Override
    public Object getTrainingSchedules() {
        return trainingScheduleRepository.findAll();
    }

    @Override
    public Object getTrainingScheduleByCrewId(long crewId) {
        return trainingScheduleRepository.findByCrewId(crewId);
    }

    @Override
    public void addTrainingSchedule(TrainingSchedule trainingSchedule) {
        trainingScheduleRepository.save(trainingSchedule);
    }


}
