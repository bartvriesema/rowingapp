package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

import java.util.List;
import java.util.Optional;

public interface TrainingSessionService {


    List<TrainingSession> getTrainingSessions();

    List<TrainingSession> getTrainingSessionsByCrewId(long crewId);

    Long addTrainingSession(TrainingSession trainingSession);

    void updateTrainingSession(long trainingSessionId, TrainingSession newTrainingSession);

    TrainingSession updateFields(TrainingSession newTrainingSession, TrainingSession currentTrainingSession);

    Optional<TrainingSession> getTrainingSessionById(Long trainingSessionId);
}
