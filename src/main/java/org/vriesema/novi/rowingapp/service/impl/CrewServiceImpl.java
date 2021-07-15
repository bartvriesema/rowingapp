package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.repository.CrewRepository;
import org.vriesema.novi.rowingapp.service.CrewService;

@Service
public class CrewServiceImpl implements CrewService {

    private CrewRepository crewRepository;

    @Autowired
    public CrewServiceImpl(CrewRepository repository) {
        this.crewRepository = repository;
    }
}
