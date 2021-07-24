package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;

public interface RowerService {

    List<Rower> getRowers();

    void addRower(Rower rower);

    Object findRowerByCrewId(long crewId);
}
