package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

import java.util.List;
import java.util.Optional;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {

    List<TrainingSession> findTrainingSessionByTrainingSchedule_Crew_Id(long crewId);

    Optional<TrainingSession> findTrainingSessionByTrainingSessionId(long trainingSessionId);
}
