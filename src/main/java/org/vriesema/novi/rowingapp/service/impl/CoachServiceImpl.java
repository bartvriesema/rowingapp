package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.vriesema.novi.rowingapp.repository.CoachRepository;
import org.vriesema.novi.rowingapp.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService {

    private CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository repository) {
        this.coachRepository = repository;
    }
}
