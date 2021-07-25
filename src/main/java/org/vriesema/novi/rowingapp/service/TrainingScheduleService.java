package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

public interface TrainingScheduleService {
    Object getTrainingSchedules();

    Object getTrainingScheduleByCrewId(long crewId);
}
