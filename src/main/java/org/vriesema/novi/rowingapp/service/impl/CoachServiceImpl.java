package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.Coach;
import org.vriesema.novi.rowingapp.repository.CoachRepository;
import org.vriesema.novi.rowingapp.service.CoachService;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private CoachRepository coachRepository;

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


}
