package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    @Autowired
    public TrainingSessionServiceImpl(TrainingSessionRepository trainingSessionRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
    }

    @Override
    public Object getTrainingSessions() {
        return trainingSessionRepository.findAll();
    }

    @Override
    public Object getTrainingSessionByCrewId(long crewId) {
        return trainingSessionRepository.findTrainingSessionByTrainingSchedule_Crew_Id(crewId);
    }

    @Override
    public void addTrainingSession(TrainingSession trainingSession) { // TODO validate input?
        trainingSessionRepository.save(trainingSession);
    }
}

