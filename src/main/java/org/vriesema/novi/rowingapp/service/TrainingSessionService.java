package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

public interface TrainingSessionService {


    Object getTrainingSessions();

    Object getTrainingSessionByCrewId(long crewId);

    void addTrainingSession(TrainingSession trainingSession);
}
