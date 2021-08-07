package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.Heartrate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;
import org.vriesema.novi.rowingapp.repository.HeartrateRepository;
import org.vriesema.novi.rowingapp.repository.RowerRepository;
import org.vriesema.novi.rowingapp.service.RowerService;

import java.util.List;
import java.util.Optional;

@Service
public class RowerServiceImpl implements RowerService {
    private final RowerRepository rowerRepository;
    private final HeartrateRepository heartrateRepository;

    @Autowired
    public RowerServiceImpl(RowerRepository rowerRepository, HeartrateRepository heartrateRepository) {
        this.rowerRepository = rowerRepository;
        this.heartrateRepository = heartrateRepository;
    }

    @Override
    public List<Rower> getRowers() {
        return rowerRepository.findAll();
    }

    @Override
    public void addRower(Rower rower) {
        rowerRepository.save(rower);
    }

    @Override
    public Object findRowerByCrewId(long crewId) {
        return rowerRepository.findRowerByCrewId(crewId);
    }

    @Override
    public Object findRowerById(long rowerId) {
        return rowerRepository.findById(rowerId);
    }

    @Override
    public void addHeartrate(long rowerId, Heartrate heartRate) {
        Optional<Rower> rower = rowerRepository.findById(rowerId);
        if (rower.isEmpty()) throw new RecordNotFoundException();
        heartRate.setRower(rower.get());
        heartrateRepository.save(heartRate);
    }

    @Override
    public List<Heartrate> getHeartrateList(long rowerId) {
        Optional<Rower> rower = rowerRepository.findById(rowerId);
        if(rower.isEmpty()) throw new RecordNotFoundException();
        return heartrateRepository.findByRower(rower.get());
    }
}



