package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;
import org.vriesema.novi.rowingapp.repository.TrainingTypeRepository;
import org.vriesema.novi.rowingapp.service.TrainingTypeService;

import java.util.List;

@Service
public class TrainingTypeServiceImpl implements TrainingTypeService {

    private final TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public TrainingTypeServiceImpl(TrainingTypeRepository repository) {
        this.trainingTypeRepository = repository;
    }

    @Override
    public List<TrainingType> getTrainingTypes() {
        return trainingTypeRepository.findAll();
    }

    @Override
    public void addTrainingType(TrainingType trainingType) {
        trainingTypeRepository.save(trainingType);
    }
}
