package org.vriesema.novi.rowingapp.service;


import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;

import java.util.List;
import java.util.Optional;

public interface TrainingScheduleService {
    List<TrainingSchedule> getTrainingSchedules();

    Optional<TrainingSchedule> getTrainingScheduleByCrewId(long crewId);

    void addTrainingSchedule(TrainingSchedule trainingSchedule);
}
