package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {

}
