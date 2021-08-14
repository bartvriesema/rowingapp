package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.repository.CoachRepository;
import org.vriesema.novi.rowingapp.service.CoachService;

import java.util.List;
import java.util.Objects;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository repository) {
        this.coachRepository = repository;
    }

    @Override
    public List<Coach> getCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public List<Coach> getClubCoaches() {
        return coachRepository.findByClubCoachTrue();
    }

    @Override
    public Long addCoach(Coach coach) {
        Coach newCoach = coachRepository.save(coach);
        return newCoach.getPersonId();
    }

    @Override
    public void updateCoach(long coachId, Coach coach) {
        Coach currentCoach;
        if (coachRepository.findById(coachId).isPresent()) {
            currentCoach = coachRepository.findById(coachId).get();
        } else {
            throw new RecordNotFoundException();
        }

        coach = updateFields(coach, currentCoach);

        coachRepository.save(coach);

    }

    @Override
    public Coach updateFields(Coach newCoach, Coach currentCoach) {

        if (Objects.isNull(newCoach.getFirstName())) {
            newCoach.setFirstName(currentCoach.getFirstName());
        }
        if (Objects.isNull(newCoach.getLastName())) {
            newCoach.setLastName(currentCoach.getLastName());
        }
        if (Objects.isNull(newCoach.getDateOfBirth())) {
            newCoach.setDateOfBirth(currentCoach.getDateOfBirth());
        }
        if (Objects.isNull(newCoach.getGender())) {
            newCoach.setGender(currentCoach.getGender());
        }
        if (Objects.isNull(newCoach.getUser())) {
            newCoach.setUser(currentCoach.getUser());
        }
        if (Objects.isNull(newCoach.getCrew())) {
            newCoach.setCrew(currentCoach.getCrew());
        }
        // TODO fix issue with isClubCoach and isCrewCoach check
        // Boolean variables cannot be compared in the same way
        // Find more efficient way to update fields in database

        return newCoach;
    }


}
