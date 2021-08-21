package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.HeartRate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;
import java.util.Optional;

public interface RowerService {

    List<Rower> getRowers();

    Long addRower(Rower rower);

    List<Rower> findRowersByCrewId(long crewId);

    Optional<Rower> findRowerById(long rowerId);

    HeartRate addHeartRate(long rowerId, HeartRate heartRate);

    List<HeartRate> getHeartRateList(long rowerId);

    long getAverageHeartRate(long rowerId);
}
