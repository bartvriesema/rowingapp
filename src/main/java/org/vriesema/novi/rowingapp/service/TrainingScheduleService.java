package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;

public interface TrainingScheduleService {
    Object getTrainingSchedules();

    Object getTrainingScheduleByCrewId(long crewId);

    void addTrainingSchedule(TrainingSchedule trainingSchedule);
}
