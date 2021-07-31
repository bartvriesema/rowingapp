package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.repository.TrainingSessionRepository;
import org.vriesema.novi.rowingapp.service.TrainingSessionService;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    @Autowired
    public TrainingSessionServiceImpl(TrainingSessionRepository repository) {
        this.trainingSessionRepository = repository;
    }
}

