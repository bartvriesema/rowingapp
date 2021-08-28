package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.repository.CoachRepository;
import org.vriesema.novi.rowingapp.service.CoachService;

import java.util.List;
import java.util.Optional;

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
        Optional<Coach> currentCoach = coachRepository.findById(coachId);
        if (currentCoach.isEmpty()) {
            throw new RecordNotFoundException();
        }

        coach = updateFields(coach, currentCoach.get());

        coachRepository.save(coach);
    }

    @Override
    public Coach updateFields(Coach newCoach, Coach currentCoach) {

        if (newCoach.getFirstName() == null) {
            newCoach.setFirstName(currentCoach.getFirstName());
        }
        if (newCoach.getLastName() == null) {
            newCoach.setLastName(currentCoach.getLastName());
        }
        if (newCoach.getDateOfBirth() == null) {
            newCoach.setDateOfBirth(currentCoach.getDateOfBirth());
        }
        if (newCoach.getGender() == null) {
            newCoach.setGender(currentCoach.getGender());
        }
        if (newCoach.getUser() == null) {
            newCoach.setUser(currentCoach.getUser());
        }
        if (newCoach.getCrew() == null) {
            newCoach.setCrew(currentCoach.getCrew());
        }
        if (!newCoach.isClubCoach()) {
            newCoach.setClubCoach(currentCoach.isClubCoach());
        }
        if (!newCoach.isCrewCoach()) {
            newCoach.setCrewCoach(currentCoach.isCrewCoach());
        }

        return newCoach;
    }


}
