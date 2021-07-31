package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.rowingclub.Crew;

import java.util.List;
import java.util.Optional;

public interface CrewService {
    List<Crew> getCrews();

    Optional<Crew> findCrewId(long crewId);

    void addCrew(Crew crew);
}
