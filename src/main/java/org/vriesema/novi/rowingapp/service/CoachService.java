package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> getCoaches();

    List<Coach> getClubCoaches();

    Long addCoach(Coach coach);

    void updateCoach(long coachId, Coach coach);

    Coach updateFields(Coach newCoach, Coach currentCoach);
}
