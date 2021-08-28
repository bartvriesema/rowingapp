package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
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
    public RowerServiceImpl(RowerRepository rowerRepository,
                            HeartrateRepository heartrateRepository) {
        this.rowerRepository = rowerRepository;
        this.heartrateRepository = heartrateRepository;
    }

    @Override
    public List<Rower> getRowers() {
        return rowerRepository.findAll();
    }

    @Override
    public Long addRower(Rower rower) {
        if (!rower.isRower()) {
            rower.setRower(true);
        }
        Rower newRower = rowerRepository.save(rower);
        return newRower.getPersonId();
    }

    @Override
    public List<Rower> findRowersByCrewId(long crewId) {
        return rowerRepository.findRowersByCrewId(crewId);
    }

    @Override
    public Optional<Rower> findRowerById(long rowerId) {
        return rowerRepository.findById(rowerId);
    }

    @Override
    public HeartRate addHeartRate(long rowerId, HeartRate heartRate) {
        Optional<Rower> rower = rowerRepository.findById(rowerId);
        if (rower.isEmpty()) throw new RecordNotFoundException();
        heartRate.setRower(rower.get());
        heartRate.setAverageHeartRate(getAverageHeartRate(rowerId));
        return heartrateRepository.save(heartRate);
    }

    @Override
    public List<HeartRate> getHeartRateList(long rowerId) {
        Optional<Rower> rower = rowerRepository.findById(rowerId);
        if (rower.isEmpty()) throw new RecordNotFoundException();

        return heartrateRepository.findByRower(rower.get());
    }

    @Override
    public long getAverageHeartRate(long rowerId) {
        List<HeartRate> heartRateList = getHeartRateList(rowerId);

        if (heartRateList.isEmpty()) return 0;

        int heartRateCounter = 0;
        int heartRateSum = 0;

        for (HeartRate heartRate : heartRateList) {
            heartRateSum = heartRateSum + heartRate.getHeartRate();
            heartRateCounter++;
        }

        return heartRateSum / heartRateCounter;
    }
}



