package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.Heartrate;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;

public interface RowerService {

    List<Rower> getRowers();

    void addRower(Rower rower);

    Object findRowerByCrewId(long crewId);

    Object findRowerById(long rowerId);

    void addHeartrate(long rowerId, Heartrate heartRate);

    List<Heartrate> getHeartrateList(long rowerId);
}
