package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.TrainingType;

public interface TrainingTypeService {
    Object getTrainingTypes();

    void addTrainingType(TrainingType trainingType);
}
