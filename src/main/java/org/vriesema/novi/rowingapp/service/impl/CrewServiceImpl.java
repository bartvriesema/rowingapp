package org.vriesema.novi.rowingapp.service.impl;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.repository.CrewRepository;
import org.vriesema.novi.rowingapp.service.CrewService;

import java.util.List;
import java.util.Optional;

@Service
public class CrewServiceImpl implements CrewService {

    private CrewRepository crewRepository;

    @Autowired
    public CrewServiceImpl(CrewRepository repository) {
        this.crewRepository = repository;
    }

    @Override
    public List<Crew> getCrews() {
        return crewRepository.findAll();
    }

    @Override
    public Optional<Crew> findCrewId(long crewId) {
        return crewRepository.findById(crewId);
    }


}
