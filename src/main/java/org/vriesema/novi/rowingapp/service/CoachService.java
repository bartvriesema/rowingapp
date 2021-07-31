package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> getCoaches();

    List<Coach> getClubCoaches();

    void addCoach(Coach coach);
}
