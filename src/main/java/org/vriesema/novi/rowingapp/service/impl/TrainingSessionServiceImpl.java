package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    @Autowired
    public TrainingSessionServiceImpl(TrainingSessionRepository trainingSessionRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
    }

    @Override
    public List<TrainingSession> getTrainingSessions() {
        return trainingSessionRepository.findAll();
    }

    @Override
    public List<TrainingSession> getTrainingSessionsByCrewId(long crewId) {
        return trainingSessionRepository.findTrainingSessionByTrainingSchedule_Crew_Id(crewId);
    }

    @Override
    public Long addTrainingSession(TrainingSession trainingSession) {

        TrainingSession newTrainingSession = trainingSessionRepository.save(trainingSession);

        return newTrainingSession.getTrainingSessionId();
    }

    @Override
    public void updateTrainingSession(long trainingSessionId, TrainingSession newTrainingSession) {
        TrainingSession currentTrainingSession;

        if (trainingSessionRepository.findTrainingSessionByTrainingSessionId(trainingSessionId).isPresent()) {
            currentTrainingSession = trainingSessionRepository.findTrainingSessionByTrainingSessionId(trainingSessionId).get();
        } else {
            throw new RecordNotFoundException();
        }

        newTrainingSession = updateFields(newTrainingSession, currentTrainingSession);

        trainingSessionRepository.save(newTrainingSession);
    }

    @Override
    public Optional<TrainingSession> getTrainingSessionById(Long trainingSessionId) {
        return trainingSessionRepository.findTrainingSessionByTrainingSessionId(trainingSessionId);
    }

    @Override
    public TrainingSession updateFields(TrainingSession newTrainingSession, TrainingSession currentTrainingSession) {

        if (newTrainingSession.getStartTime() == null) {
            newTrainingSession.setStartTime(currentTrainingSession.getStartTime());
        }
        if (newTrainingSession.getEndTime() == null) {
            newTrainingSession.setEndTime(currentTrainingSession.getEndTime());
        }
        if (newTrainingSession.getShortDescription() == null) {
            newTrainingSession.setShortDescription(currentTrainingSession.getShortDescription());
        }
        if (newTrainingSession.getLongDescription() == null) {
            newTrainingSession.setLongDescription(currentTrainingSession.getLongDescription());
        }
        if (newTrainingSession.getTrainingType() == null) {
            newTrainingSession.setTrainingType(currentTrainingSession.getTrainingType());
        }
        if (newTrainingSession.getTrainingSchedule() == null) {
            newTrainingSession.setTrainingSchedule(currentTrainingSession.getTrainingSchedule());
        }

        return newTrainingSession;

    }


}

