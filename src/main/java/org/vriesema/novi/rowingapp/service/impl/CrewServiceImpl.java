package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;
import org.vriesema.novi.rowingapp.repository.CrewRepository;
import org.vriesema.novi.rowingapp.repository.TrainingScheduleRepository;
import org.vriesema.novi.rowingapp.service.CrewService;

import java.util.List;
import java.util.Optional;

@Service
public class CrewServiceImpl implements CrewService {

    private final CrewRepository crewRepository;
    private final TrainingScheduleRepository trainingScheduleRepository;

    @Autowired
    public CrewServiceImpl(CrewRepository crewRepository,
                           TrainingScheduleRepository trainingScheduleRepository) {
        this.crewRepository = crewRepository;
        this.trainingScheduleRepository = trainingScheduleRepository;
    }

    @Override
    public List<Crew> getCrews() {
        return crewRepository.findAll();
    }

    @Override
    public Optional<Crew> findByCrewId(long crewId) {
        return crewRepository.findById(crewId);
    }

    @Override
    public void addCrew(Crew crew) {
        Crew newCrew = crewRepository.save(crew);

        // Also create trainingschedule for this crew
        TrainingSchedule trainingSchedule = new TrainingSchedule();
        trainingSchedule.setCrew(newCrew);
        trainingScheduleRepository.save(trainingSchedule);

    }


}
