package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;

import java.util.List;
import java.util.Objects;
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
    public Long addTrainingSession(TrainingSession trainingSession) { // TODO validate input?

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

        if (Objects.isNull(newTrainingSession.getStartTime())) {
            newTrainingSession.setStartTime(currentTrainingSession.getStartTime());
        }
        if (Objects.isNull(newTrainingSession.getEndTime())) {
            newTrainingSession.setEndTime(currentTrainingSession.getEndTime());
        }
        if (Objects.isNull(newTrainingSession.getShortDescription())) {
            newTrainingSession.setShortDescription(currentTrainingSession.getShortDescription());
        }
        if (Objects.isNull(newTrainingSession.getLongDescription())) {
            newTrainingSession.setLongDescription(currentTrainingSession.getLongDescription());
        }
        if (Objects.isNull(newTrainingSession.getTrainingType())) {
            newTrainingSession.setTrainingType(currentTrainingSession.getTrainingType());
        }
        if (Objects.isNull(newTrainingSession.getTrainingSchedule())) {
            newTrainingSession.setTrainingSchedule(currentTrainingSession.getTrainingSchedule());
        }

        return newTrainingSession;

    }


}

