package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

import java.util.List;

public interface CrewService {
    List<Crew> getCrews();

    Object findCrewId(long crewId);
}
