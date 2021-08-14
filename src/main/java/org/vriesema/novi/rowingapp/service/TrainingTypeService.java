package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

import java.util.List;

public interface TrainingTypeService {
    List<TrainingType> getTrainingTypes();

    void addTrainingType(TrainingType trainingType);
}
