package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.vriesema.novi.rowingapp.repository.TrainingTypeRepository;
import org.vriesema.novi.rowingapp.service.TrainingTypeService;

public class TrainingTypeServiceImpl implements TrainingTypeService {

    private TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public TrainingTypeServiceImpl(TrainingTypeRepository repository) {
        this.trainingTypeRepository = repository;
    }
}
