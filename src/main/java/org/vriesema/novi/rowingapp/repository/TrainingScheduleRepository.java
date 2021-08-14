package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSchedule;

import java.util.Optional;

public interface TrainingScheduleRepository extends JpaRepository<TrainingSchedule, Long> {

    Optional<TrainingSchedule> findByCrewId(long crewId);

}
