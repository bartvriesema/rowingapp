package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

public interface TrainingTypeService {
    Object getTrainingTypes();

    void addTrainingType(TrainingType trainingType);
}
